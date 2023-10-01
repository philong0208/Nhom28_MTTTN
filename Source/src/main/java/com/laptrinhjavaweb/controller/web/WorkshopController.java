package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "workshopControllerOfWeb")
public class WorkshopController {

	@RequestMapping(value = "/workshop", method = RequestMethod.GET)
	public ModelAndView workshopList() {
		return new ModelAndView("redirect:" + "http://workshop.laptrinhjavaweb.com/");
	}
}
