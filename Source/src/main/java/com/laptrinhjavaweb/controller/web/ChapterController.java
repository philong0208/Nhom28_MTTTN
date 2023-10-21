package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.dto.PostDTO;
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
@Controller(value = "chapterControllerOfWeb")
public class ChapterController {
    @Autowired
    private IChapterService chapterService;
    @RequestMapping(value = "/chuong/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable("id") Long postId) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        ChapterDTO model = chapterService.findById(postId);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
    @RequestMapping(value = "/tin-tuc/{categorycode}/{seourl}-{id}", method = RequestMethod.GET)
    public ModelAndView getDetail(@ModelAttribute(SystemConstant.MODEL) NewDTO model, @PathVariable("id") long id) {
        NewDTO dto = newsService.findById(id);
        if (dto == null) {
            return new ModelAndView("redirect:/" + "notfound");
        }
        ModelAndView mav = new ModelAndView("web/blog/detail");
        mav.addObject("categories", newsCategoryService.getCategoriesByCode());
        NewCategoryDTO modelCategory = newsCategoryService.findById(dto.getNewCategoryId());
        if (modelCategory != null) {
            mav.addObject("categoryCode", modelCategory.getCode());
        }
        mav.addObject(SystemConstant.MODEL, dto);
        return mav;
    }
}
