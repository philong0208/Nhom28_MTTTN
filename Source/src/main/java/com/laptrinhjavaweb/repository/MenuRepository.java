package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.MenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    @Query(value = "SELECT m FROM MenuEntity m ORDER BY m.index asc ")
    List<MenuEntity> findAllMenus();

    @Query(value = "SELECT m FROM MenuEntity m ORDER BY m.index asc")
    Page<MenuEntity> findAllMenus(Pageable pageable);
}
