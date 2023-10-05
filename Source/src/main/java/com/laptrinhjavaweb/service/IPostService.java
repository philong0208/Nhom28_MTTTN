package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PostDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostService {
    List<PostDTO> findAll(String shortTitle, Pageable pageable);
//    List<PostDTO> findAll(PostBuilder postBuilder, Pageable pageable);
    int getTotalItems(String shortTitle);
//    int getTotalItems(PostBuilder postBuilder);
    PostDTO insert(PostDTO postDTO);
    PostDTO findById(long id);
    PostDTO update(PostDTO postDTO);
    void deletePost(long[] ids);
    List<PostDTO> findByHotPost(String value);
    List<PostDTO> findBySlidePost(String value);
    List<PostDTO> findByMenuConfiguration(String value);
    PostDTO findBySeoUrl(String seoUrl);
    List<PostDTO> findAllTalk(Pageable pageable);
    int getTotalItemsTalk();
    List<PostDTO> findByCategory(String code, Pageable pageable);
    int getTotalItemsByCategory(String code);
    PostDTO findByShortUrl(String shortUrl);
}
