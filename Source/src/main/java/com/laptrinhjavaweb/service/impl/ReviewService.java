package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ReviewConverter;
import com.laptrinhjavaweb.dto.ReviewDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.entity.ReviewEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.repository.ReviewRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewConverter reviewConverter;
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<ReviewDTO> findByPost_Id(Long id) {
        return reviewRepository.findByPost_Id(id).stream().map(
                item -> reviewConverter.convertToDto(item)).collect(Collectors.toList());
    }
    @Override
    public ReviewDTO insertOrUpdateReview(ReviewDTO reviewDTO) {
        ReviewEntity reviewEntity = reviewRepository.findByPost_IdAndUser_Id(reviewDTO.getPostId(), reviewDTO.getUserId());
        PostEntity postEntity = postRepository.findById(reviewDTO.getPostId()).get();
        long reviewAmount = reviewRepository.countByPost_Id(reviewDTO.getPostId());
        if (reviewEntity != null) {
            reviewEntity.setContent(reviewDTO.getContent());
            postEntity.setScore((postEntity.getScore() * reviewAmount - reviewEntity.getScore() + reviewDTO.getScore()) / reviewAmount);
            reviewEntity.setScore(reviewDTO.getScore());
        } else {
            reviewEntity = reviewConverter.convertToEntity(reviewDTO);
            postEntity.setScore((postEntity.getScore() * reviewAmount + reviewDTO.getScore()) / (reviewAmount + 1));
        }
        postRepository.save(postEntity);

        return reviewConverter.convertToDto(reviewRepository.save(reviewEntity));
    }
    @Override
    public ReviewDTO alreadyHaveReview(Long postId) {
        if (SecurityUtils.notLoginYet()) {
            return null;
        }
        Long reviewUserId = SecurityUtils.getPrincipal().getId();
        return reviewRepository.findByPost_IdAndUser_Id(postId, reviewUserId) != null
                ? reviewConverter.convertToDto(reviewRepository.findByPost_IdAndUser_Id(postId, reviewUserId))
                : null;
    }
}
