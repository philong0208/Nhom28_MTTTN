package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.AuthorEntity;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.entity.TagEntity;
import com.laptrinhjavaweb.repository.ChapterRepository;
import com.laptrinhjavaweb.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private IUserService iUserService;

    public PostDTO convertToDto (PostEntity entity){
        PostDTO result = modelMapper.map(entity, PostDTO.class);
        result.setTagCodeArray(entity.getTags().stream()
                .map(TagEntity::getCode)
                .toArray(String[]::new));
        result.setTagNameStr(entity.getTags().stream()
                .map(TagEntity::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse(null));
        result.setAuthorCodeArray(entity.getAuthors().stream()
                .map(AuthorEntity::getCode)
                .toArray(String[]::new));
        result.setAuthorNameStr(entity.getAuthors().stream()
                .map(AuthorEntity::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse(null));
        chapterRepository.findByPost_Id(entity.getId()).forEach(
                item -> result.getNameOfChapters().add(item.getShortTitle()));
        result.setCreatedByFullName(iUserService.findOneByUserName(entity.getCreatedBy()).getFullName());
        return result;
    }

    public PostEntity convertToEntity (PostDTO dto) {
        PostEntity result = modelMapper.map(dto, PostEntity.class);
        return result;
    }
}
