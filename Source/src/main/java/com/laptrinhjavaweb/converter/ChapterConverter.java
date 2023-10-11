package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.entity.AuthorEntity;
import com.laptrinhjavaweb.entity.ChapterEntity;
import com.laptrinhjavaweb.entity.TagEntity;
import com.laptrinhjavaweb.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChapterConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService iUserService;

    public ChapterDTO convertToDto (ChapterEntity entity){
        ChapterDTO result = modelMapper.map(entity, ChapterDTO.class);
        result.setCreatedByFullName(iUserService.findOneByUserName(entity.getCreatedBy()).getFullName());
        return result;
    }

    public ChapterEntity convertToEntity (ChapterDTO dto) {
        ChapterEntity result = modelMapper.map(dto, ChapterEntity.class);
        return result;
    }
}
