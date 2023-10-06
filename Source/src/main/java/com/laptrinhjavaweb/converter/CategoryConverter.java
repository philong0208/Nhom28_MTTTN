package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.service.IPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;
    public CategoryDTO convertToDto(CategoryEntity entity) {
        CategoryDTO result = modelMapper.map(entity, CategoryDTO.class);
        postRepository.findByCategory_Id(entity.getId()).forEach(
                item -> result.getNameOfPosts().add(item.getShortTitle()));
        return result;
    }

    public CategoryEntity convertToEntity(CategoryDTO dto) {
        CategoryEntity result = modelMapper.map(dto, CategoryEntity.class);
        return result;
    }
}
