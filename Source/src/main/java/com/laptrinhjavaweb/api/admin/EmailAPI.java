package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.EmailDTO;
import com.laptrinhjavaweb.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "emailApiOfAdmin")
@RequestMapping(value = "/api/admin/email")
public class EmailAPI {

    @Autowired
    private IEmailService emailService;

    @PostMapping
    public void sentMailAuto(@RequestBody EmailDTO emailDTO) throws Exception {
        emailService.sentMailAuto(emailDTO);
    }
}
