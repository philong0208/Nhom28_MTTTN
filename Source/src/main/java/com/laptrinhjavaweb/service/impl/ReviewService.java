package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CommentConverter;
import com.laptrinhjavaweb.converter.ReviewConverter;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.dto.ReviewDTO;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.repository.ReviewRepository;
import com.laptrinhjavaweb.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewConverter reviewConverter;
    @Override
    public List<ReviewDTO> findByPost_Id(Long id) {
        return reviewRepository.findByPost_Id(id).stream().map(
                item -> reviewConverter.convertToDto(item)).collect(Collectors.toList());
    }
    @Override
    public ReviewDTO insert(ReviewDTO reviewDTO) {
        return reviewConverter.convertToDto(reviewRepository.save(reviewConverter.convertToEntity(reviewDTO)));
    }
}
