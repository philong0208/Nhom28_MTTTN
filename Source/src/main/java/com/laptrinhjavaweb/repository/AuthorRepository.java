package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    AuthorEntity findOneByCode(String code);
    Page<AuthorEntity> findAll(Pageable pageable);
    Page<AuthorEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    long countByNameContainingIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    boolean existsByCodeIgnoreCase(String code);
}
