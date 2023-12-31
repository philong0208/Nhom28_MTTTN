package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.service.IChapterService;
import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "chapterControllerOfWeb")
public class ChapterController {
    @Autowired
    private IChapterService chapterService;
    @Autowired
    private IPostService postService;
    @Autowired
    private ICommentService commentService;
    @RequestMapping(value = "/tieu-thuyet/{shortTitle}-{pId}/{chapterCode}-{id}", method = RequestMethod.GET)
    public ModelAndView getDetail(@ModelAttribute(SystemConstant.MODEL) ChapterDTO model,
                                  @PathVariable("shortTitle") String shortTitle,
                                  @PathVariable("pId") Long pId,
                                  @PathVariable("chapterCode") String chapterCode,
                                  @PathVariable("id") long id) {
        ChapterDTO chapterDTO = chapterService.findByIdApproved(id);
        if (chapterDTO == null) {
            return new ModelAndView("redirect:/" + "notfound");
        }
        ModelAndView mav = new ModelAndView("web/chapter/detail");
        List<ChapterDTO> chapterList =
                chapterService.findByPost_ShortTitleAndAndApprovedIsTrue(shortTitle,
                        Sort.by("shortTitle").ascending());
        mav.addObject("chapterList", chapterList);
        mav.addObject("thisChapter", chapterDTO.getShortTitle());
        mav.addObject(SystemConstant.MODEL, chapterDTO);
        List<CommentDTO> comments = commentService.findByChapter_Id(id);
        mav.addObject("comments", comments);
        mav.addObject("postShortTitle", shortTitle);
        mav.addObject("postId", pId);
        postService.increaseView(pId);
        return mav;
    }
}
