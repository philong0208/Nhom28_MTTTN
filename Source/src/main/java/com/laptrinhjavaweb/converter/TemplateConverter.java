package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.TemplateDTO;
import com.laptrinhjavaweb.entity.TemplateEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplateConverter {

    @Autowired
    private ModelMapper modelMapper;

    public TemplateDTO convertToDto(TemplateEntity entity) {
        return modelMapper.map(entity, TemplateDTO.class);
    }

    public TemplateEntity convertToEntity(TemplateDTO dto) {
        return modelMapper.map(dto, TemplateEntity.class);
    }
}
