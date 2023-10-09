package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findOneByCode(String code);
    Page<CategoryEntity> findAll(Pageable pageable);
    Page<CategoryEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    long countByNameContainingIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    boolean existsByCodeIgnoreCase(String code);
    boolean existsByCodeIgnoreCaseAndIdNot(String code, long id);
    boolean existsByNameIgnoreCaseAndIdNot(String name, long id);
    void deleteAllByIdIn(long[] ids);
}
