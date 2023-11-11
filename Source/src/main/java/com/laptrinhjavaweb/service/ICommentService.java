package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CommentDTO;

import java.util.List;

public interface ICommentService {
    List<CommentDTO> findByChapter_Id(Long id);
    CommentDTO insertOrUpdateComment(CommentDTO commentDTO);
    CommentDTO alreadyHaveComment(Long chapterId);
}
