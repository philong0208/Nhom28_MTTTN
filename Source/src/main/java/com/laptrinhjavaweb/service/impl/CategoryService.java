package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Map<String, String> getCategories() {
        Map<String, String> results = new HashMap<>();
        categoryRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(item -> categoryConverter.convertToDto(item)).collect(Collectors.toList());
        return categoryDTOS;
    }

    @Override
    public List<CategoryDTO> findAll(String name, Pageable pageable) {
        List<CategoryEntity> results = null;
        if (StringUtils.isNotBlank(name)) {
            results = categoryRepository.findByNameContainingIgnoreCase(name, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.by("modifiedDate").descending())).getContent();
        } else {
            results = categoryRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.by("modifiedDate").descending())).getContent();
        }
        return results.stream().map(item -> categoryConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public int getTotalItems(String name) {
        if (StringUtils.isNotBlank(name)) {
            return (int) categoryRepository.countByNameContainingIgnoreCase(name);
        } else {
            return (int) categoryRepository.count();
        }
    }

    @Override
    public CategoryDTO findById(long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        return categoryConverter.convertToDto(categoryEntity);
    }

    @Override
    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryConverter.convertToEntity(categoryDTO);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryConverter.convertToDto(categoryEntity);
    }

    @Override
    @Transactional
    public CategoryDTO update(CategoryDTO categoryDTO) {
        CategoryEntity existsCategory = categoryRepository.findById(categoryDTO.getId()).get();
        CategoryEntity updateCategory = categoryConverter.convertToEntity(categoryDTO);
        updateCategory.setCreatedBy(existsCategory.getCreatedBy());
        updateCategory.setCreatedDate(existsCategory.getCreatedDate());
        categoryRepository.save(updateCategory);
        return categoryConverter.convertToDto(updateCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(long[] ids) {
        for (long item : ids) {
            CategoryEntity categoryEntity = categoryRepository.findById(item).get();
            if (categoryEntity.getPosts() != null && categoryEntity.getPosts().size() > 0) {
                categoryEntity.getPosts().remove(categoryEntity.getPosts().iterator().next());
            }
            categoryRepository.deleteById(item);
        }
    }
    @Override
    @Transactional
    public String deleteCategoryWithoutPost(long[] ids) {
        categoryRepository.deleteAllByIdIn(ids);
        return "success";
    }
    @Override
    public boolean hasPost(long[] ids) {
        return Arrays.stream(ids)
                .anyMatch(id -> categoryRepository.findById(id)
                        .map(categoryEntity -> !categoryEntity.getPosts().isEmpty())
                        .orElse(false));
    }
    @Override
    public CategoryDTO findByCode(String code) {
        return categoryConverter.convertToDto(categoryRepository.findOneByCode(code));
    }
}
