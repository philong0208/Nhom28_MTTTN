package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CommentConverter;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentConverter commentConverter;
    @Override
    public List<CommentDTO> findByChapter_Id(Long id) {
        return commentRepository.findByChapter_Id(id).stream().map(
                item -> commentConverter.convertToDto(item)).collect(Collectors.toList());
    }
    @Override
    public CommentDTO insertOrUpdateComment(CommentDTO commentDTO) {
        CommentEntity commentEntity = commentRepository.findByChapter_IdAndUser_Id(commentDTO.getChapterId(), commentDTO.getUserId());
        if (commentEntity != null) {
            commentEntity.setContent(commentDTO.getContent());
        } else {
            commentEntity = commentConverter.convertToEntity(commentDTO);
        }
        return commentConverter.convertToDto(commentRepository.save(commentEntity));
    }
    @Override
    public CommentDTO alreadyHaveComment(Long chapterId) {
        if (SecurityUtils.notLoginYet()) {
            return null;
        }
        Long commentUserId = SecurityUtils.getPrincipal().getId();
        return commentRepository.findByChapter_IdAndUser_Id(chapterId, commentUserId) != null
                ? commentConverter.convertToDto(commentRepository.findByChapter_IdAndUser_Id(chapterId, commentUserId))
                : null;
    }
}
