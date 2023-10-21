package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CommentConverter;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.repository.CommentRepository;
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
}
