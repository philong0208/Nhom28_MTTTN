package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByPost_Id(Long id);
}
