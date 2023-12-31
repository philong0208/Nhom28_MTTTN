package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "categoryApiOfAdmin")
@RequestMapping(value = "/api/admin/category")
public class CategoryAPI {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryRepository.existsByCodeIgnoreCase(categoryDTO.getCode())
                || categoryRepository.existsByNameIgnoreCase(categoryDTO.getName())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(categoryService.insert(categoryDTO));
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryRepository.existsByCodeIgnoreCaseAndIdNot(categoryDTO.getCode(), categoryDTO.getId())
                || categoryRepository.existsByNameIgnoreCaseAndIdNot(categoryDTO.getName(), categoryDTO.getId())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(categoryService.update(categoryDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCategory(@RequestBody long[] ids) {
        return categoryService.hasPost(ids)
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(categoryService.deleteCategoryWithoutPost(ids));
    }
}
