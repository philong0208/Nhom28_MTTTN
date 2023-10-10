package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ChapterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<ChapterEntity, Long> {
    Page<ChapterEntity> findByShortTitleContainingIgnoreCase(String shortTitle, Pageable pageable);
    long countByShortTitleContainingIgnoreCase(String shortTitle);
    boolean existsByShortTitleIgnoreCase(String shortTitle);
    boolean existsByShortTitleIgnoreCaseAndIdNot(String shortTitle, long id);
    List<ChapterEntity> findByPost_Id(long postId);
}
