package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CategoryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    Map<String, String> getCategories();
    List<CategoryDTO> findAll();
    List<CategoryDTO> findAll(String name, Pageable pageable);
    int getTotalItems(String name);
    CategoryDTO findById(long id);
    CategoryDTO insert(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO);
    void deleteCategory(long[] ids);
    CategoryDTO findByCode(String code);
}
