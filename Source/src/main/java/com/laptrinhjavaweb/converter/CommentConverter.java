package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
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
    @Autowired
    private UserRepository userRepository;

    public CommentDTO convertToDto(CommentEntity entity){
        CommentDTO result = modelMapper.map(entity, CommentDTO.class);
        return result;
    }

    public CommentEntity convertToEntity(CommentDTO dto) {
        CommentEntity result = modelMapper.map(dto, CommentEntity.class);
        result.setUser(userRepository.findOneByUserName(SecurityUtils.getPrincipal().getUsername()));
        return result;
    }
}
