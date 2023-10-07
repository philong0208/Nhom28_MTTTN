package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/post")
public class PostAPI {

    @Autowired
    private IPostService postService;
    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return postRepository.existsByShortTitleIgnoreCase(postDTO.getShortTitle())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(postService.insert(postDTO));
    }

    @PutMapping
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.update(postDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteNew(@RequestBody long[] ids) {
        if (ids.length > 0) {
            postService.deletePost(ids);
        }
        return ResponseEntity.ok("success");
    }
}
