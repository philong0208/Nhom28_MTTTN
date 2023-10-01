package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.builder.MenuBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.*;
import com.laptrinhjavaweb.service.IMasterDataService;
import com.laptrinhjavaweb.service.IMenuService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.MessageResponseUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "menuControllerOfAdmin")
public class MenuController {

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IMasterDataService masterDataService;

	@RequestMapping(value = "/admin/menu-page/list", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute(SystemConstant.MODEL) MenuFilter model,
							   HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/menu-page/list");
		DisplayTagUtils.of(request, model);
		model.setMaxPageItems(1000);
		Pageable pageable = PageRequest.of(model.getPage() - 1, model.getMaxPageItems());
		MenuBuilder postBuilder = new MenuBuilder();
		Page<MenuDTO> res = menuService.search(postBuilder, pageable);
		model.setListResult(res.getContent());
		model.setTotalItems(res.getTotalPages());
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/menu-page/edit", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute(SystemConstant.MODEL) MenuDTO model,
							 @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/menu-page/edit");
		if (id != null) {
			model = menuService.findById(id);
		}
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.POSITIONS, masterDataService.getMenuType());
		mav.addObject(SystemConstant.LIST_PARENT_MENU, menuService.getParentMenu());
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
		String message = request.getParameter("message");
		if (message != null && StringUtils.isNotEmpty(message)) {
			Map<String, String> messageMap = MessageResponseUtils.getMessage(message);
			mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
			mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
		}
	}
}
