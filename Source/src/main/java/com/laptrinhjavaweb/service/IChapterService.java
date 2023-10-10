package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ChapterDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IChapterService {
    List<ChapterDTO> findAll(String shortTitle, Pageable pageable);
    int getTotalItems(String shortTitle);
    ChapterDTO insert(ChapterDTO chapterDTO);
    ChapterDTO findById(long id);
    ChapterDTO update(ChapterDTO chapterDTO);
    void deleteChapter(long[] ids);
}
