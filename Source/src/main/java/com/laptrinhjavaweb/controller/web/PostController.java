package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "postControllerOfWeb")
public class PostController {
    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/tieu-thuyet/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable("id") Long postId) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        PostDTO model = postService.findById(postId);
        model.setCanonicalUrl(model.getSeoUrl() + "-" + model.getId());
        model.setOgUrl(model.getSeoUrl() + "-" + model.getId());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @RequestMapping(value = "/san-pham", method = RequestMethod.GET)
    public ModelAndView productList(@ModelAttribute(SystemConstant.SEARCH_MODEL) ProductCategoryDTO searchModel, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/product/list");
        searchModel.setMaxPageItems(20);
        ProductDTO model = new ProductDTO();
        Pageable pageable = new PageRequest(searchModel.getPage() - 1, searchModel.getMaxPageItems());
        model.setListResult(productService.findAll(searchModel, pageable));
        model.setTotalItems(productService.getTotalItems(searchModel));
        model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItems()));
        mav.addObject("categories", productCategoryService.getProductCategories());
        mav.addObject("sizes", productService.getSizeProduct());
        String categoryCode = getCategoryCode(searchModel);
        ProductCategoryDTO productCategoryDTO = productCategoryService.findByCode(categoryCode);
        mav.addObject("category", productCategoryDTO);
        mav.addObject(SystemConstant.SEARCH_MODEL, searchModel);
        mav.addObject(SystemConstant.MODEL, model);
        String title = "Tìm kiếm";
        if (categoryCode != null && categoryCode.length() > 0) {
            if (productCategoryDTO.getCode() == null) {
                title = "Không tìm thấy - Gạch men italianhome";
            } else {
                title = productCategoryDTO.getName() + "- Gạch men italianhome";
            }
        }
        SeoFriendlyUrlService seoFriendlyUrlSvc = new SeoFriendlyUrlService();
        seoFriendlyUrlSvc.init(request, title, productCategoryDTO.getShortDescription(), "");
        mav.addObject(SystemConstant.MODEL_SEO_PAGE, seoFriendlyUrlSvc.GetSeoPage());
        return mav;
    }
}