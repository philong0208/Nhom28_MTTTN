package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.AuthorDTO;
import com.laptrinhjavaweb.service.IAuthorService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.MessageResponseUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "authorControllerOfAdmin")
public class AuthorController {

	@Autowired
	private IAuthorService authorService;

	@RequestMapping(value = "/admin/author/list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) AuthorDTO model,
								HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/author/list");
		DisplayTagUtils.of(request, model);
		Pageable pageable = PageRequest.of(model.getPage() - 1, model.getMaxPageItems());
		List<AuthorDTO> authorDTOS = authorService.findAll(model.getName(), pageable);
		model.setListResult(authorDTOS);
		model.setTotalItems(authorService.getTotalItems(model.getName()));
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/author/edit", method = RequestMethod.GET)
	public ModelAndView editPostPage(@ModelAttribute(SystemConstant.MODEL) AuthorDTO model,
									 @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/author/edit");
		if (id != null) {
			model = authorService.findById(id);
		}
		initMessageResponse(mav, request);
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