package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PostDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface IPostService {
    List<PostDTO> findAll(String shortTitle, Pageable pageable);

    List<PostDTO> filter(String shortTitle,
                         String tagCode,
                         String authorCode,
                         Pageable pageable);

    int getTotalFilterItems(String shortTitle,
                            String tagCode,
                            String authorCode);

    int getTotalItems(String shortTitle);
    PostDTO insert(PostDTO postDTO);
    PostDTO findById(long id);
    PostDTO update(PostDTO postDTO);
    void increaseView(long id);
    void deletePost(long[] ids);
    PostDTO findByIdApproved(long id);
    List<PostDTO> findByHotPost(String value);
    List<PostDTO> findBySlidePost(String value);
    List<PostDTO> findByMenuConfiguration(String value);
    PostDTO findBySeoUrl(String seoUrl);
    List<PostDTO> findAllTalk(Pageable pageable);
    int getTotalItemsTalk();
    List<PostDTO> findByCategory(String code, Pageable pageable);
    int getTotalItemsByCategory(String code);
    PostDTO findByShortUrl(String shortUrl);
    Map<Long, String> getPosts();
    @Transactional
    String deletePostWithoutChapter(long[] ids);
    boolean hasChapter(long[] ids);
    List<PostDTO> top6LatestApproved();
    List<PostDTO> top6MostViewApproved();
    List<PostDTO> top6MostRateApproved();
    List<PostDTO> top6RelatedPostApproved(String[] tagCodeArray);
}
