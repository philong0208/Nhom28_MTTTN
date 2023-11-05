package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.ReviewDTO;
import com.laptrinhjavaweb.repository.ReviewRepository;
import com.laptrinhjavaweb.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "reviewApiOfAdmin")
@RequestMapping(value = "/api/admin/review")
public class ReviewAPI {

    @Autowired
    private IReviewService reviewService;
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.insert(reviewDTO));
    }
}
