package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.AuthorDTO;
import com.laptrinhjavaweb.repository.AuthorRepository;
import com.laptrinhjavaweb.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "authorApiOfAdmin")
@RequestMapping(value = "/api/admin/author")
public class AuthorAPI {

    @Autowired
    private IAuthorService authorService;
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorRepository.existsByCodeIgnoreCase(authorDTO.getCode())
                || authorRepository.existsByNameIgnoreCase(authorDTO.getName())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(authorService.insert(authorDTO));
    }

    @PutMapping
    public ResponseEntity<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorRepository.existsByCodeIgnoreCaseAndIdNot(authorDTO.getCode(), authorDTO.getId())
                || authorRepository.existsByNameIgnoreCaseAndIdNot(authorDTO.getName(), authorDTO.getId())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(authorService.update(authorDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAuthor(@RequestBody long[] ids) {
        return authorService.hasPost(ids)
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(authorService.deleteAuthorWithoutPost(ids));
    }
}
