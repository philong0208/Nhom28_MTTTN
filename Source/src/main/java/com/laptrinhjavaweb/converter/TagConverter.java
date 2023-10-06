package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.TagDTO;
import com.laptrinhjavaweb.entity.TagEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagConverter {

    @Autowired
    private ModelMapper modelMapper;

    public TagDTO convertToDto(TagEntity entity) {
        return modelMapper.map(entity, TagDTO.class);
    }

    public TagEntity convertToEntity(TagDTO dto) {
        return modelMapper.map(dto, TagEntity.class);
    }
}
