package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.service.IAuthorService;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IChapterService;
import com.laptrinhjavaweb.service.ITagService;
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
import java.util.Map;
import java.util.Optional;

@Controller(value = "chapterControllerOfAdmin")
public class ChapterController {

	@Autowired
	private IChapterService chapterService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private ITagService tagService;
	@Autowired
	private IAuthorService authorService;
	@RequestMapping(value = "/admin/chapter/list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) ChapterDTO model,
                                HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/chapter/list");
		DisplayTagUtils.of(request, model);
		Pageable pageable = PageRequest.of(model.getPage() - 1, model.getMaxPageItems());
		model.setListResult(chapterService.findAll(Optional.ofNullable(model.getShortTitle()).orElse(""), pageable));
		model.setTotalItems(chapterService.getTotalItems(Optional.ofNullable(model.getShortTitle()).orElse("")));
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/chapter/edit", method = RequestMethod.GET)
	public ModelAndView editChapterPage(@ModelAttribute(SystemConstant.MODEL) ChapterDTO model,
                                     @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/chapter/edit");
		if (id != null) {
			model = chapterService.findById(id);
		}
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.CATEGORIES, categoryService.getCategories());
		mav.addObject(SystemConstant.TAGS, tagService.getTags());
		mav.addObject(SystemConstant.AUTHORS, authorService.getAuthors());
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
