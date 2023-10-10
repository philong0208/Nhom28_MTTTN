package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.AuthorConverter;
import com.laptrinhjavaweb.dto.AuthorDTO;
import com.laptrinhjavaweb.entity.AuthorEntity;
import com.laptrinhjavaweb.repository.AuthorRepository;
import com.laptrinhjavaweb.service.IAuthorService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorConverter authorConverter;

    @Override
    public Map<String, String> getAuthors() {
        Map<String, String> results = new HashMap<>();
        authorRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }
    @Override
    public Map<String, AuthorEntity> getAuthorEntity() {
        Map<String, AuthorEntity> results = new HashMap<>();
        authorRepository.findAll().forEach(item -> results.put(item.getCode(), item));
        return results;
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<AuthorEntity> authors = authorRepository.findAll();
        List<AuthorDTO> authorDTOS = authors.stream().map(item -> authorConverter.convertToDto(item)).collect(Collectors.toList());
        return authorDTOS;
    }

    @Override
    public List<AuthorDTO> findAll(String name, Pageable pageable) {
        List<AuthorEntity> results = null;
        if (StringUtils.isNotBlank(name)) {
            results = authorRepository.findByNameContainingIgnoreCase(name, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.by("modifiedDate").descending())).getContent();
        } else {
            results = authorRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.by("modifiedDate").descending())).getContent();
        }
        return results.stream().map(item -> authorConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public int getTotalItems(String name) {
        if (StringUtils.isNotBlank(name)) {
            return (int) authorRepository.countByNameContainingIgnoreCase(name);
        } else {
            return (int) authorRepository.count();
        }
    }

    @Override
    public AuthorDTO findById(long id) {
        AuthorEntity authorEntity = authorRepository.findById(id).get();
        return authorConverter.convertToDto(authorEntity);
    }

    @Override
    @Transactional
    public AuthorDTO insert(AuthorDTO authorDTO) {
        AuthorEntity authorEntity = authorConverter.convertToEntity(authorDTO);
        authorEntity = authorRepository.save(authorEntity);
        return authorConverter.convertToDto(authorEntity);
    }

    @Override
    @Transactional
    public AuthorDTO update(AuthorDTO authorDTO) {
        AuthorEntity existsAuthor = authorRepository.findById(authorDTO.getId()).get();
        AuthorEntity updateAuthor = authorConverter.convertToEntity(authorDTO);
        updateAuthor.setCreatedBy(existsAuthor.getCreatedBy());
        updateAuthor.setCreatedDate(existsAuthor.getCreatedDate());
        authorRepository.save(updateAuthor);
        return authorConverter.convertToDto(updateAuthor);
    }

    @Override
    @Transactional
    public void deleteAuthor(long[] ids) {
        for (long item : ids) {
            AuthorEntity authorEntity = authorRepository.findById(item).get();
            if (authorEntity.getPosts() != null && authorEntity.getPosts().size() > 0) {
                authorEntity.getPosts().remove(authorEntity.getPosts().iterator().next());
            }
            authorRepository.deleteById(item);
        }
    }
    @Override
    @Transactional
    public String deleteAuthorWithoutPost(long[] ids) {
        authorRepository.deleteAllByIdIn(ids);
        return "success";
    }
    @Override
    public boolean hasPost(long[] ids) {
        return Arrays.stream(ids)
                .anyMatch(id -> authorRepository.findById(id)
                        .map(tagEntity -> !tagEntity.getPosts().isEmpty())
                        .orElse(false));
    }

    @Override
    public AuthorDTO findByCode(String code) {
        return authorConverter.convertToDto(authorRepository.findOneByCode(code));
    }
}
