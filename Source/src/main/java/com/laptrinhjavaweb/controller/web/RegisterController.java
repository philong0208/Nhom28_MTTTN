package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller()
public class RegisterController {

    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public ModelAndView contact(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/register");
        return mav;
    }
}
