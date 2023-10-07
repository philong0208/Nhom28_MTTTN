package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.AuthorDTO;
import com.laptrinhjavaweb.entity.AuthorEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IAuthorService {
    Map<String, String> getAuthors();
    Map<String, AuthorEntity> getAuthorEntity();
    List<AuthorDTO> findAll();
    List<AuthorDTO> findAll(String name, Pageable pageable);
    int getTotalItems(String name);
    AuthorDTO findById(long id);
    AuthorDTO insert(AuthorDTO authorDTO);
    AuthorDTO update(AuthorDTO authorDTO);
    void deleteAuthor(long[] ids);
    AuthorDTO findByCode(String code);
}
