package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CommentConverter;
import com.laptrinhjavaweb.converter.ReviewConverter;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.repository.ReviewRepository;
import com.laptrinhjavaweb.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewConverter reviewConverter;
}
