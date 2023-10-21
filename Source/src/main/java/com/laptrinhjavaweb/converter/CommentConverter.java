package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.ChapterEntity;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService iUserService;

    public CommentDTO convertToDto(CommentEntity entity){
        CommentDTO result = modelMapper.map(entity, CommentDTO.class);
        return result;
    }

    public CommentEntity convertToEntity(CommentDTO dto) {
        CommentEntity result = modelMapper.map(dto, CommentEntity.class);
        return result;
    }
}
