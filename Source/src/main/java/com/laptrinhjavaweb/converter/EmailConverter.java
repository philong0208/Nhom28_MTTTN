package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.EmailDTO;
import com.laptrinhjavaweb.entity.EmailEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailConverter {

    @Autowired
    private ModelMapper modelMapper;

    public EmailDTO convertToDto(EmailEntity entity) {
        EmailDTO result = modelMapper.map(entity, EmailDTO.class);
        return result;
    }

    public EmailEntity convertToEntity(EmailDTO dto) {
        EmailEntity result = modelMapper.map(dto, EmailEntity.class);
        return result;
    }
}
