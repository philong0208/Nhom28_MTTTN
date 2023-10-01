package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "categoryControllerOfWeb")
public class CategoryController {

    @RequestMapping(value = "/dich-vu/{categorycode}", method = RequestMethod.GET)
    public ModelAndView servicePageByCategory(@PathVariable("categorycode") String categoryCode) {
        String url = null;
        switch(categoryCode){
            case "shop":
                url = "https://laptrinhjavawebshop.com";
                break;
            case "software":
                url = "http://laptrinhjavawebsoftware.com";
                break;
            case "khoa-hoc":
                url = "https://laptrinhjavawebacademy.com";
                break;
        }
        return new ModelAndView("redirect:" + url);
    }
}
