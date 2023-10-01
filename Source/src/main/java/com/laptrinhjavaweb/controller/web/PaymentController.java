package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "paymentControllerOfWeb")
public class PaymentController {

	@RequestMapping(value = "/thanh-toan-online", method = RequestMethod.GET)
	public ModelAndView bookBuy() {
		ModelAndView mav = new ModelAndView("web/payment/checkout");
		return mav;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView bookFinal() {
		ModelAndView mav = new ModelAndView("web/payment/success");
		return mav;
	}
}
