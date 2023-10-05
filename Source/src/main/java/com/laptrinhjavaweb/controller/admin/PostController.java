package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IPostService;
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller(value = "postControllerOfAdmin")
public class PostController {

	@Autowired
	private IPostService postService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "/admin/post/list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) PostDTO model,
                                HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/post/list");
		DisplayTagUtils.of(request, model);
		Pageable pageable = PageRequest.of(model.getPage() - 1, model.getMaxPageItems());
//		PostBuilder postBuilder = new PostBuilder.Builder()
//				.setShortTitle(model.getShortTitle() != null ? model.getShortTitle() : "")
//				.setType(SystemConstant.ADMIN_POST_LIST)
//				.build();
//		List<PostDTO> posts = postService.findAll(postBuilder, pageable);
		List<PostDTO> posts = postService.findAll(model.getShortTitle() != null ? model.getShortTitle() : "", pageable);
		model.setListResult(posts);
		model.setTotalItems(postService.getTotalItems(model.getShortTitle() != null ? model.getShortTitle() : ""));
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/post/edit", method = RequestMethod.GET)
	public ModelAndView editPostPage(@ModelAttribute(SystemConstant.MODEL) PostDTO model,
                                     @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/post/edit");
		if (id != null) {
			model = postService.findById(id);
		}
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.CATEGORIES, categoryService.getCategories());
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
