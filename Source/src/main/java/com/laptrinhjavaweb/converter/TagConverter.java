package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.TagDTO;
import com.laptrinhjavaweb.entity.TagEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepository;

    public TagDTO convertToDto(TagEntity entity) {
        TagDTO tagDTO = modelMapper.map(entity, TagDTO.class);
        postRepository.findByTags_Id(entity.getId()).forEach(
                item -> tagDTO.getNameOfPosts().add(item.getShortTitle()));
        return tagDTO;
    }

    public TagEntity convertToEntity(TagDTO dto) {
        return modelMapper.map(dto, TagEntity.class);
    }
}
