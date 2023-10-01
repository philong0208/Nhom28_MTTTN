package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "podcastControllerOfWeb")
public class PodcastController {

	@RequestMapping(value = "/podcast", method = RequestMethod.GET)
	public ModelAndView podcastList() {
		return new ModelAndView("redirect:" + "https://www.youtube.com/playlist?list=PLW1k06REn7Hv9dF9lyAtFXiN0Um5rZFD-");
	}
}
