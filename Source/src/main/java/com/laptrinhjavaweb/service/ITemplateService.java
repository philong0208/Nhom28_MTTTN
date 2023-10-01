package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.TemplateDTO;

public interface ITemplateService {
    TemplateDTO getTemplate(String pageName) throws Exception;
    TemplateDTO save(TemplateDTO templateDT);
}
