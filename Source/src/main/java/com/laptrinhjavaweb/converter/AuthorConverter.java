package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.AuthorDTO;
import com.laptrinhjavaweb.entity.AuthorEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepository;

    public AuthorDTO convertToDto(AuthorEntity entity) {
        AuthorDTO authorDTO = modelMapper.map(entity, AuthorDTO.class);
        postRepository.findByAuthors_Id(entity.getId()).forEach(
                item -> authorDTO.getNameOfPosts().add(item.getShortTitle()));
        return authorDTO;
    }

    public AuthorEntity convertToEntity(AuthorDTO dto) {
        return modelMapper.map(dto, AuthorEntity.class);
    }
}
