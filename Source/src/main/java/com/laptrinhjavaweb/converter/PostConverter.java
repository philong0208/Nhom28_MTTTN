package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.dto.TagDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.entity.TagEntity;
import com.laptrinhjavaweb.service.ITagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PostConverter {

    @Autowired
    private ModelMapper modelMapper;

    public PostDTO convertToDto (PostEntity entity){
        PostDTO result = modelMapper.map(entity, PostDTO.class);
        result.setTagArray(entity.getTags().stream()
                .map(TagEntity::getCode)
                .toArray(String[]::new));
        return result;
    }

    public PostEntity convertToEntity (PostDTO dto) {
        PostEntity result = modelMapper.map(dto, PostEntity.class);
        return result;
    }
}
