package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.dto.ReviewDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.entity.ReviewEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    public ReviewDTO convertToDto(ReviewEntity entity){
        ReviewDTO dto = modelMapper.map(entity, ReviewDTO.class);
        return dto;
    }

    public ReviewEntity convertToEntity(ReviewDTO dto) {
        ReviewEntity entity = modelMapper.map(dto, ReviewEntity.class);
        entity.setUser(userRepository.findOneByUserName(SecurityUtils.getPrincipal().getUsername()));
        return entity;
    }
}
