package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.EmailDTO;

import javax.mail.NoSuchProviderException;

public interface IEmailService {
    EmailDTO save(EmailDTO emailDTO);
    void sentMailAuto(EmailDTO emailDTO) throws Exception;
}
