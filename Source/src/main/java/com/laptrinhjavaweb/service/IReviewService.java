package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.dto.ReviewDTO;

import java.util.List;

public interface IReviewService {
    List<ReviewDTO> findByPost_Id(Long id);
}
