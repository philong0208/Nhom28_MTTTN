package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    @Autowired
    private ModelMapper modelMapper;

    public PostDTO convertToDto (PostEntity entity){
        PostDTO result = modelMapper.map(entity, PostDTO.class);
        return result;
    }

    public PostEntity convertToEntity (PostDTO dto) {
        PostEntity result = modelMapper.map(dto, PostEntity.class);
        return result;
    }
}
