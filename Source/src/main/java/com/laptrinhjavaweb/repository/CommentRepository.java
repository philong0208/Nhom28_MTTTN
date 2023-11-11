package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByChapter_Id(Long id);
    CommentEntity findByChapter_IdAndUser_Id(Long chapterId, Long userId);
}
