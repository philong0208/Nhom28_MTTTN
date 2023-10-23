package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.dto.ReviewDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.entity.ReviewEntity;
import com.laptrinhjavaweb.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService iUserService;

    public ReviewDTO convertToDto(ReviewEntity entity){
        ReviewDTO result = modelMapper.map(entity, ReviewDTO.class);
        return result;
    }

    public ReviewEntity convertToEntity(ReviewDTO dto) {
        ReviewEntity result = modelMapper.map(dto, ReviewEntity.class);
        return result;
    }
}
