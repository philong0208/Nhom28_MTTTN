package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.service.IChapterService;
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
import java.util.List;
import java.util.Optional;

@Controller(value = "postControllerOfWeb")
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    private IChapterService chapterService;

    @RequestMapping(value = "/tieu-thuyet/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable("id") Long postId) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        PostDTO model = postService.findById(postId);
        model.setCanonicalUrl(model.getSeoUrl() + "-" + model.getId());
        model.setOgUrl(model.getSeoUrl() + "-" + model.getId());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
    @RequestMapping(value = "/tieu-thuyet", method = RequestMethod.GET)
    public ModelAndView getAll(@ModelAttribute(SystemConstant.MODEL) PostDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/post/list");
        model.setMaxPageItems(16);
        Pageable pageable = new PageRequest(model.getPage() - 1, model.getMaxPageItems());
        model.setListResult(postService.findAll(Optional.ofNullable(model.getShortTitle()).orElse(""), pageable));
        model.setTotalItems(postService.getTotalItems(Optional.ofNullable(model.getShortTitle()).orElse("")));
        model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
    @RequestMapping(value = "/san-pham/{shortTitle}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable("shortTitle") String shortTitle, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        PostDTO postDTO = postService.findById(109L);
        if (postDTO == null){
            return new ModelAndView("redirect:/error/404");
        }
        String img = postDTO.getThumbnail();
        mav.addObject("defaultImage", postDTO.getThumbnail());
        String[] images = img.split(",", -1);
        mav.addObject("images", images);
        mav.addObject("product", postDTO);
        mav.addObject("relatedProducts", postService.findAll("", new PageRequest(0, 20)));
        List<ChapterDTO> chapterList = chapterService.findByPost_ShortTitle(postDTO.getShortTitle());
        mav.addObject("chapterList", chapterList);

        /*SeoFriendlyUrlService seoFriendlyUrlSvc = new SeoFriendlyUrlService();
        String ogTitle = productDTO.getOgTitle();
        if (ogTitle == null || ogTitle.length() == 0) {
            ogTitle = "Sản phẩm gạch - " + productDTO.getCode();
        }
        seoFriendlyUrlSvc.init(request, ogTitle, productDTO.getOgDesc(), "");
        mav.addObject(SystemConstant.MODEL_SEO_PAGE, seoFriendlyUrlSvc.GetSeoPage());*/
        return mav;
    }
    @RequestMapping(value = "/error/404", method = RequestMethod.GET)
    public ModelAndView errorNotFoundPage() {
        return new ModelAndView("web/errors/404");
    }
//    @RequestMapping(value = "/tieu-thuyet", method = RequestMethod.GET)
//    public ModelAndView productList(@ModelAttribute("searchModel") ProductCategoryDTO searchModel, HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView("web/product/list");
//        searchModel.setMaxPageItems(20);
//        ProductDTO model = new ProductDTO();
//        Pageable pageable = new PageRequest(searchModel.getPage() - 1, searchModel.getMaxPageItems());
//        model.setListResult(productService.findAll(searchModel, pageable));
//        model.setTotalItems(productService.getTotalItems(searchModel));
//        model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItems()));
//        mav.addObject("categories", productCategoryService.getProductCategories());
//        mav.addObject("sizes", productService.getSizeProduct());
//        String categoryCode = getCategoryCode(searchModel);
//        ProductCategoryDTO productCategoryDTO = productCategoryService.findByCode(categoryCode);
//        mav.addObject("category", productCategoryDTO);
//        mav.addObject(SystemConstant.SEARCH_MODEL, searchModel);
//        mav.addObject(SystemConstant.MODEL, model);
//        String title = "Tìm kiếm";
//        if (categoryCode != null && categoryCode.length() > 0) {
//            if (productCategoryDTO.getCode() == null) {
//                title = "Không tìm thấy - Gạch men italianhome";
//            } else {
//                title = productCategoryDTO.getName() + "- Gạch men italianhome";
//            }
//        }
//        SeoFriendlyUrlService seoFriendlyUrlSvc = new SeoFriendlyUrlService();
//        seoFriendlyUrlSvc.init(request, title, productCategoryDTO.getShortDescription(), "");
//        mav.addObject(SystemConstant.MODEL_SEO_PAGE, seoFriendlyUrlSvc.GetSeoPage());
//        return mav;
//    }
}