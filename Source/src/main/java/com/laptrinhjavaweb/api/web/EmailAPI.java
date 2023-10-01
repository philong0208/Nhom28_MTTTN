package com.laptrinhjavaweb.api.web;

import com.laptrinhjavaweb.dto.EmailDTO;
import com.laptrinhjavaweb.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "emailApiOfWeb")
@RequestMapping(value = "/api/web/email")
public class EmailAPI {

    @Autowired
    private IEmailService emailService;

    @PostMapping
    public ResponseEntity<EmailDTO> saveMail(@RequestBody EmailDTO emailDTO) {
        return ResponseEntity.ok(emailService.save(emailDTO));
    }
}
