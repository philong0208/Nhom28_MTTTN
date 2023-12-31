package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AuthorEntity;
import com.laptrinhjavaweb.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    AuthorEntity findOneByCode(String code);
    Page<AuthorEntity> findAll(Pageable pageable);
    Page<AuthorEntity> findByCreatedBy(String createdBy, Pageable pageable);
    Page<AuthorEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    long countByNameContainingIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    boolean existsByCodeIgnoreCase(String code);
    boolean existsByCodeIgnoreCaseAndIdNot(String code, long id);
    boolean existsByNameIgnoreCaseAndIdNot(String name, long id);
    void deleteAllByIdIn(long[] ids);
    Page<AuthorEntity> findByNameContainingIgnoreCaseAndCreatedBy(String name, String createdBy, Pageable pageable);
    long countByNameContainingIgnoreCaseAndCreatedBy(String name, String createdBy);
    long countByCreatedBy(String username);
}
