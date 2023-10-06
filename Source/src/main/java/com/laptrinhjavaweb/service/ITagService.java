package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.TagDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ITagService {
    Map<String, String> getTags();
    List<TagDTO> findAll();
    List<TagDTO> findAll(String name, Pageable pageable);
    int getTotalItems(String name);
    TagDTO findById(long id);
    TagDTO insert(TagDTO tagDTO);
    TagDTO update(TagDTO tagDTO);
    void deleteTag(long[] ids);
    TagDTO findByCode(String code);
}
