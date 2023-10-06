package com.laptrinhjavaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView("admin/home");
		return modelAndView;
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {

		String referrer = request.getHeader("Referer");
		if(referrer!=null){
			request.getSession().setAttribute("url_prior_login", referrer);
		}
		return "login";
	}
}
