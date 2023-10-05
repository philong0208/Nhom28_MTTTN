package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.service.IPostService;
//import org.apache.log4j.Logger;
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

    //private Logger logger = Logger.getLogger(PostController.class);

    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/{seourl}-{id}", method = RequestMethod.GET)
    public ModelAndView courseAdvancedDetail(@PathVariable("id") Long postId, @PathVariable("seourl") String seoUrl) {
        String modelAndView = "web/post/detail";
        if (seoUrl.equals(SystemConstant.JAVA_WEB_BASIC_ADVANTAGE)) {
            return new ModelAndView("redirect:/"+seoUrl+"");
        }
        if (seoUrl.equals(SystemConstant.JAVA_WEB_BASIC)) {
            return new ModelAndView("redirect:/"+seoUrl+"");
        }
        if (seoUrl.equals(SystemConstant.CONTACT)) {
            return new ModelAndView("redirect:/"+seoUrl+"");
        }
        if (seoUrl.equals(SystemConstant.PAYMENT)) {
            return new ModelAndView("redirect:/"+seoUrl+"");
        }
        if (seoUrl.equals(SystemConstant.SPRING_MVC)) {
            return new ModelAndView("redirect:/"+seoUrl+"");
        }
        if (seoUrl.equals(SystemConstant.SPRING_BOOT)) {
            return new ModelAndView("redirect:/"+seoUrl+"");
        }
        if (seoUrl.equals("khoa-hoc-java-phong-van-di-lam")) {
            modelAndView = "web/course/java-core";
        }
        if (seoUrl.equals("khoa-hoc-deploy-java-web-len-hosting")) {
            modelAndView = "web/course/java-hosting";
        }
        ModelAndView mav = new ModelAndView(modelAndView);
        PostDTO model = postService.findById(postId);
        model.setCanonicalUrl(model.getSeoUrl() +"-"+ model.getId());
        model.setOgUrl(model.getSeoUrl() +"-"+ model.getId());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/tieu-thuyet/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable("id") Long postId) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        PostDTO model = postService.findById(postId);
        model.setCanonicalUrl(model.getSeoUrl() +"-"+ model.getId());
        model.setOgUrl(model.getSeoUrl() +"-"+ model.getId());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
    @RequestMapping(value = "/khoa-hoc-java-web-co-ban-den-nang-cao", method = RequestMethod.GET)
    public ModelAndView academyJavaWebCourse(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/course/java-web");
        String url = request.getRequestURI().substring(1);
        PostDTO model = postService.findBySeoUrl(url);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = {"/khoa-hoc-java-web-co-ban-jsp-servlet-jdbc-va-mysql",
                             "/thanh-toan","/lien-he","/springmvc","/springboot"}, method = RequestMethod.GET)
    public ModelAndView jspServletPaymentContactSpringBootSpringMvc(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/post/detail");
        String url = request.getRequestURI().substring(1);
        PostDTO model = postService.findBySeoUrl(url);
        model.setCanonicalUrl(model.getSeoUrl());
        model.setOgUrl(model.getSeoUrl());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = {"/tam-su-lap-trinh"}, method = RequestMethod.GET)
    public ModelAndView showTalk(@ModelAttribute(SystemConstant.MODEL) PostDTO model) {
        ModelAndView mav = new ModelAndView("web/talk/list");
        Pageable pageable = PageRequest.of(model.getPage() - 1, model.getMaxPageItems());
        model.setListResult(postService.findAllTalk(pageable));
        model.setTotalItems(postService.getTotalItemsTalk());
        model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = {"/s/{url}"}, method = RequestMethod.GET)
    public ModelAndView showByShortUrl(@PathVariable("url") String url) {
        PostDTO postDTO = postService.findByShortUrl(url);
        return new ModelAndView("redirect:/"+postDTO.getRedirectUrl());
    }
}
