package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.ChapterConverter;
import com.laptrinhjavaweb.dto.ChapterDTO;
import com.laptrinhjavaweb.entity.ChapterEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ChapterRepository;
import com.laptrinhjavaweb.repository.TagRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IChapterService;
import com.laptrinhjavaweb.utils.UploadFileUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChapterService implements IChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private ChapterConverter chapterConverter;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;

    @Value("${dir.default}")
    private String dirDefault;
    @Override
    public List<ChapterDTO> findAll(String shortTitle, Pageable pageable) {
        PageRequest sort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by("modifiedDate").descending());
        return (SecurityUtils.isAdmin() ? chapterRepository.findByShortTitleContainingIgnoreCase(shortTitle,
                        sort) : chapterRepository.findByShortTitleContainingIgnoreCaseAndCreatedBy(shortTitle,
                        SecurityUtils.getPrincipal().getUsername(), sort))
                .getContent().stream().map(item -> chapterConverter.convertToDto(item)).collect(Collectors.toList());
    }
    @Override
    public List<ChapterDTO> findByPostId(Long id, Pageable pageable) {
        return chapterRepository.findByPost_Id(id,
                        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                                Sort.by("modifiedDate").descending()))
                .getContent().stream().map(item -> chapterConverter.convertToDto(item)).collect(Collectors.toList());
    }
    @Override
    public int getTotalItems(String shortTitle) {
        return SecurityUtils.isAdmin() ? (int) chapterRepository.countByShortTitleContainingIgnoreCase(shortTitle)
                : (int) chapterRepository.countByShortTitleContainingIgnoreCaseAndCreatedBy(shortTitle,
                SecurityUtils.getPrincipal().getUsername());
    }
    @Override
    public int getTotalItemsByPostId(Long id) {
        return (int) chapterRepository.countByPost_Id(id);
    }

    @Override
    @Transactional
    public ChapterDTO insert(ChapterDTO chapterDTO) {
        try {
            ChapterEntity chapterEntity = chapterConverter.convertToEntity(chapterDTO);
            saveThumbnail(chapterDTO, chapterEntity);
            chapterEntity = chapterRepository.save(chapterEntity);
            return chapterConverter.convertToDto(chapterEntity);
        } catch (Exception e) {
            return new ChapterDTO();
        }
    }

    @Override
    @Transactional
    public ChapterDTO update(ChapterDTO chapterDTO) {
        try {
            ChapterEntity existsChapter = chapterRepository.findById(chapterDTO.getId()).get();
            ChapterEntity updateChapter = chapterConverter.convertToEntity(chapterDTO);
            updateChapter.setCreatedBy(existsChapter.getCreatedBy());
            updateChapter.setCreatedDate(existsChapter.getCreatedDate());
            if (existsChapter.getModifiedBy() != null) {
                updateChapter.setModifiedBy(existsChapter.getModifiedBy());
            }
            if (existsChapter.getModifiedDate() != null) {
                updateChapter.setModifiedDate(existsChapter.getModifiedDate());
            }
            updateChapter.setThumbnail(existsChapter.getThumbnail());
            saveThumbnail(chapterDTO, updateChapter);
            chapterRepository.save(updateChapter);
            return chapterConverter.convertToDto(updateChapter);
        } catch (Exception e) {
            return chapterDTO;
        }
    }

    @Override
    @Transactional
    public void deleteChapter(long[] ids) {
        for (long item : ids) {
            chapterRepository.deleteById(item);
        }
    }

    @Override
    public ChapterDTO findById(long id) {
        ChapterEntity chapterEntity = chapterRepository.findById(id).get();
        return chapterConverter.convertToDto(chapterEntity);
    }

    private void saveThumbnail(ChapterDTO chapterDTO, ChapterEntity chapterEntity) {
        String path = SystemConstant.CHAPTER_IMAGE + "/" + chapterDTO.getThumbnailImageName();
        if (chapterDTO.getThumbnailBase64() != null) {
            if (chapterEntity.getThumbnail() != null) {
                if (!path.equals(chapterEntity.getThumbnail())) {
                    File file = new File(dirDefault + chapterEntity.getThumbnail());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(chapterDTO.getThumbnailBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            chapterEntity.setThumbnail(path);
        }
    }
}
