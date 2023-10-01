package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.TemplateDTO;
import com.laptrinhjavaweb.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "configurationThemeControllerOfAdmin")
public class ConfigurationThemeController {

	@Autowired
	private ITemplateService templateService;

	@RequestMapping(value = "/admin/configuration/theme/default/home-page", method = RequestMethod.GET)
	public ModelAndView page() throws Exception {
		ModelAndView modelAndView = new ModelAndView("admin/page/home_page");
		TemplateDTO page =  templateService.getTemplate(SystemConstant.PAGE_NAME_LANDING);
		modelAndView.addObject(SystemConstant.MODEL, page);
		return modelAndView;
	}
}
