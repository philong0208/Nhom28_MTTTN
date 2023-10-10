package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.repository.ChapterRepository;
import com.laptrinhjavaweb.service.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/chapter")
public class ChapterAPI {

    @Autowired
    private IChapterService chapterService;
    @Autowired
    private ChapterRepository chapterRepository;

    @PostMapping
    public ResponseEntity<ChapterDTO> createChapter(@RequestBody ChapterDTO chapterDTO) {
        return chapterRepository.existsByShortTitleIgnoreCase(chapterDTO.getShortTitle())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(chapterService.insert(chapterDTO));
    }

    @PutMapping
    public ResponseEntity<ChapterDTO> updateChapter(@RequestBody ChapterDTO chapterDTO) {
        return chapterRepository.existsByShortTitleIgnoreCaseAndIdNot(chapterDTO.getShortTitle(), chapterDTO.getId())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(chapterService.update(chapterDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteNew(@RequestBody long[] ids) {
        if (ids.length > 0) {
            chapterService.deleteChapter(ids);
        }
        return ResponseEntity.ok("success");
    }
}
