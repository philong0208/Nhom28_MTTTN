package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AuthorEntity;
import com.laptrinhjavaweb.entity.ChapterEntity;
import com.laptrinhjavaweb.entity.PostEntity;
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
    Page<ChapterEntity> findByPost_Id(Long id, Pageable pageable);
    Page<ChapterEntity> findByPost_IdAndCreatedBy(Long id, String createdBy, Pageable pageable);
    long countByPost_Id(Long id);
    long countByPost_IdAndCreatedBy(Long id, String createdBy);
    Page<ChapterEntity> findByShortTitleContainingIgnoreCaseAndCreatedBy(String shortTitle, String createdBy, Pageable pageable);
    long countByShortTitleContainingIgnoreCaseAndCreatedBy(String shortTitle, String createdBy);
    List<ChapterEntity> findByPost_ShortTitle(String shortTitle);
    List<ChapterEntity> findByPost_ShortTitleAndAndApprovedIsTrue(String shortTitle);
}