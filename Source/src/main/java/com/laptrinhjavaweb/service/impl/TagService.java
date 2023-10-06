package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.TagConverter;
import com.laptrinhjavaweb.dto.TagDTO;
import com.laptrinhjavaweb.entity.TagEntity;
import com.laptrinhjavaweb.repository.TagRepository;
import com.laptrinhjavaweb.service.ITagService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TagService implements ITagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagConverter tagConverter;

    @Override
    public Map<String, String> getTags() {
        Map<String, String> results = new HashMap<>();
        tagRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }

    @Override
    public List<TagDTO> findAll() {
        List<TagEntity> tags = tagRepository.findAll();
        List<TagDTO> tagDTOS = tags.stream().map(item -> tagConverter.convertToDto(item)).collect(Collectors.toList());
        return tagDTOS;
    }

    @Override
    public List<TagDTO> findAll(String name, Pageable pageable) {
        List<TagEntity> results = null;
        if (StringUtils.isNotBlank(name)) {
            results = tagRepository.findByNameContainingIgnoreCase(name, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.by("modifiedDate").descending())).getContent();
        } else {
            results = tagRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.by("modifiedDate").descending())).getContent();
        }
        return results.stream().map(item -> tagConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public int getTotalItems(String name) {
        if (StringUtils.isNotBlank(name)) {
            return (int) tagRepository.countByNameContainingIgnoreCase(name);
        } else {
            return (int) tagRepository.count();
        }
    }

    @Override
    public TagDTO findById(long id) {
        TagEntity tagEntity = tagRepository.findById(id).get();
        return tagConverter.convertToDto(tagEntity);
    }

    @Override
    @Transactional
    public TagDTO insert(TagDTO tagDTO) {
        TagEntity tagEntity = tagConverter.convertToEntity(tagDTO);
        tagEntity = tagRepository.save(tagEntity);
        return tagConverter.convertToDto(tagEntity);
    }

    @Override
    @Transactional
    public TagDTO update(TagDTO tagDTO) {
        TagEntity existsTag = tagRepository.findById(tagDTO.getId()).get();
        TagEntity updateTag = tagConverter.convertToEntity(tagDTO);
        updateTag.setCreatedBy(existsTag.getCreatedBy());
        updateTag.setCreatedDate(existsTag.getCreatedDate());
        tagRepository.save(updateTag);
        return tagConverter.convertToDto(updateTag);
    }

    @Override
    @Transactional
    public void deleteTag(long[] ids) {
        for (long item : ids) {
            TagEntity tagEntity = tagRepository.findById(item).get();
            if (tagEntity.getPosts() != null && tagEntity.getPosts().size() > 0) {
                tagEntity.getPosts().remove(tagEntity.getPosts().iterator().next());
            }
            tagRepository.deleteById(item);
        }
    }

    @Override
    public TagDTO findByCode(String code) {
        return tagConverter.convertToDto(tagRepository.findOneByCode(code));
    }
}
