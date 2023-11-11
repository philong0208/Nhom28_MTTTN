package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.dto.ReviewDTO;
import com.laptrinhjavaweb.entity.ReviewEntity;
import com.laptrinhjavaweb.repository.ReviewRepository;
import com.laptrinhjavaweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private IReviewService reviewService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private ReviewRepository reviewRepository;

    /*@RequestMapping(value = "/tieu-thuyet/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable("id") Long postId) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        PostDTO model = postService.findById(postId);
        model.setCanonicalUrl(model.getSeoUrl() + "-" + model.getId());
        model.setOgUrl(model.getSeoUrl() + "-" + model.getId());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }*/
    @RequestMapping(value = "/tieu-thuyet2", method = RequestMethod.GET)
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
    @RequestMapping(value = "/tieu-thuyet", method = RequestMethod.GET)
    public ModelAndView productList(@ModelAttribute("model") PostDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/post/list");
        model.setMaxPageItems(40);

        Pageable pageable = new PageRequest(model.getPage() - 1, model.getMaxPageItems());
        List<PostDTO> filter = postService.filter(
                Optional.ofNullable(model.getShortTitle()).orElse(""),
                Optional.ofNullable(model.getTagNameStr()).orElse(""),
                Optional.ofNullable(model.getAuthorNameStr()).orElse(""),
                pageable);
        model.setListResult(filter);
        int totalFilterItems = postService.getTotalFilterItems(null,null,null);
        model.setTotalItems(totalFilterItems);
        model.setTotalPages((int) Math.ceil((double) totalFilterItems / model.getMaxPageItems()));

        // combo box
        mav.addObject("tags", tagService.getTags());
        mav.addObject("authors", authorService.getAuthors());

        // hiển thị giới thiệu
        /*mav.addObject("category", productCategoryService.findByCode(getCategoryCode(searchModel)));*/

        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
    @RequestMapping(value = "/tieu-thuyet/{shortTitle}-{id}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable("shortTitle") String shortTitle,
                                      @PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        PostDTO postDTO = postService.findByIdApproved(id);
        if (postDTO == null){
            return new ModelAndView("redirect:/error/404");
        }
        String img = postDTO.getThumbnail();
        mav.addObject("defaultImage", postDTO.getThumbnail());
        String[] images = img.split(",", -1);
        mav.addObject("images", images);
        mav.addObject("product", postDTO);
        mav.addObject("relatedProducts", postService.top6RelatedPostApproved(postDTO.getTagCodeArray()));
        List<ChapterDTO> chapterList =
                chapterService.findByPost_ShortTitleAndAndApprovedIsTrue(postDTO.getShortTitle(),
                        Sort.by("shortTitle").ascending());
        mav.addObject("chapterList", chapterList);
        List<ReviewDTO> reviews = reviewService.findByPost_Id(postDTO.getId());
        mav.addObject("reviews", reviews);
        ReviewDTO yourReview = reviewService.alreadyHaveReview(id);
        mav.addObject("alreadyHaveReview", yourReview != null);
        if (yourReview != null) {
            reviews.removeIf(review -> review.getId().equals(yourReview.getId()));
            mav.addObject("yourReview", yourReview);
        }
        mav.addObject("yourUserId", yourReview != null ? yourReview.getUserId() : null);
        return mav;
    }
    @RequestMapping(value = "/error/404", method = RequestMethod.GET)
    public ModelAndView errorNotFoundPage() {
        return new ModelAndView("web/errors/404");
    }
}