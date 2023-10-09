package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
    TagEntity findOneByCode(String code);
    Page<TagEntity> findAll(Pageable pageable);
    Page<TagEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    long countByNameContainingIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    boolean existsByCodeIgnoreCase(String code);
}
