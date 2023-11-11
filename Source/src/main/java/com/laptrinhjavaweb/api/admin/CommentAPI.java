package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "commentApiOfAdmin")
@RequestMapping(value = "/api/admin/comment")
public class CommentAPI {

    @Autowired
    private ICommentService commentService;
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    public ResponseEntity<CommentDTO> insertOrUpdateComment(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.insertOrUpdateComment(commentDTO));
    }
}
