package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.entity.TagEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    @Autowired
    private ModelMapper modelMapper;

    public PostDTO convertToDto (PostEntity entity){
        PostDTO result = modelMapper.map(entity, PostDTO.class);
        result.setTagCodeArray(entity.getTags().stream()
                .map(TagEntity::getCode)
                .toArray(String[]::new));
        result.setTagNameStr(entity.getTags().stream()
                .map(TagEntity::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse(null));
        return result;
    }

    public PostEntity convertToEntity (PostDTO dto) {
        PostEntity result = modelMapper.map(dto, PostEntity.class);
        return result;
    }
}
