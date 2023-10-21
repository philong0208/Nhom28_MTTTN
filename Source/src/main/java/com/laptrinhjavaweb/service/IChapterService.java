package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ChapterDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IChapterService {
    List<ChapterDTO> findAll(String shortTitle, Pageable pageable);
    List<ChapterDTO> findByPostId(Long id, Pageable pageable);
    int getTotalItems(String shortTitle);
    int getTotalItemsByPostId(Long id);
    ChapterDTO insert(ChapterDTO chapterDTO);
    ChapterDTO findById(long id);
    ChapterDTO update(ChapterDTO chapterDTO);
    void deleteChapter(long[] ids);
    List<ChapterDTO> findByPost_ShortTitle(String shortTitle);
}
