package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
