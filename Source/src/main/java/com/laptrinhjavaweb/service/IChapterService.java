package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ChapterDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IChapterService {
    List<ChapterDTO> findAll(String shortTitle, Pageable pageable);
    List<ChapterDTO> findByPostId(Long id, Pageable pageable);
    int getTotalItems(String shortTitle);
    int getTotalItemsByPostId(Long id);
    ChapterDTO insert(ChapterDTO chapterDTO);
    List<ChapterDTO> findByPost_ShortTitleAndAndApprovedIsTrue(String shortTitle, Sort sort);
    ChapterDTO findById(long id);
    ChapterDTO findByIdApproved(long id);
    ChapterDTO update(ChapterDTO chapterDTO);
    void deleteChapter(long[] ids);
    List<ChapterDTO> findByPost_ShortTitle(String shortTitle);
}
