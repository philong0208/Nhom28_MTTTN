package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.TagDTO;
import com.laptrinhjavaweb.entity.TagEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ITagService {
    Map<String, String> getTags();
    Map<String, TagEntity> getTagEntity();
    List<TagDTO> findAll();
    List<TagDTO> findAll(String name, Pageable pageable);
    int getTotalItems(String name);
    TagDTO findById(long id);
    TagDTO insert(TagDTO tagDTO);
    TagDTO update(TagDTO tagDTO);
    void deleteTag(long[] ids);

    @Transactional
    String deleteTagWithoutPost(long[] ids);

    boolean hasPost(long[] ids);

    TagDTO findByCode(String code);
}
