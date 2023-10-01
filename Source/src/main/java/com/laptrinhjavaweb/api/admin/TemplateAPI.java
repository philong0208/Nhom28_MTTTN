package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.TemplateDTO;
import com.laptrinhjavaweb.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "templateApiOfAdmin")
@RequestMapping(value = "/api/admin/template")
public class TemplateAPI {

    @Autowired
    private ITemplateService templateService;

    @PostMapping
    public ResponseEntity<TemplateDTO> save(@RequestBody TemplateDTO templateDTO) {
        return ResponseEntity.ok(templateService.save(templateDTO));
    }
}
