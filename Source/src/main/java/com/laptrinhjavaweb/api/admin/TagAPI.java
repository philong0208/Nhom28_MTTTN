package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.TagDTO;
import com.laptrinhjavaweb.repository.TagRepository;
import com.laptrinhjavaweb.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "tagApiOfAdmin")
@RequestMapping(value = "/api/admin/tag")
public class TagAPI {

    @Autowired
    private ITagService tagService;
    @Autowired
    private TagRepository tagRepository;

    @PostMapping
    public ResponseEntity<TagDTO> createTag(@RequestBody TagDTO tagDTO) {
        return tagRepository.existsByCodeIgnoreCase(tagDTO.getCode())
                || tagRepository.existsByNameIgnoreCase(tagDTO.getName())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(tagService.insert(tagDTO));
    }

    @PutMapping
    public ResponseEntity<TagDTO> updateTag(@RequestBody TagDTO tagDTO) {
        return tagRepository.existsByCodeIgnoreCaseAndIdNot(tagDTO.getCode(), tagDTO.getId())
                || tagRepository.existsByNameIgnoreCaseAndIdNot(tagDTO.getName(), tagDTO.getId())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(tagService.update(tagDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTag(@RequestBody long[] ids) {
        return tagService.hasPost(ids)
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(tagService.deleteTagWithoutPost(ids));
    }
}
