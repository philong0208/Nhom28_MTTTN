package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}