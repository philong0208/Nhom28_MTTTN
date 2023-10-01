package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.TemplateConverter;
import com.laptrinhjavaweb.dto.TemplateDTO;
import com.laptrinhjavaweb.entity.TemplateEntity;
import com.laptrinhjavaweb.repository.TemplateRepository;
import com.laptrinhjavaweb.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TemplateService implements ITemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private TemplateConverter templateConverter;

    @Override
    @Transactional
    public TemplateDTO save(TemplateDTO templateDTO) {
        TemplateEntity templateEntity = templateConverter.convertToEntity(templateDTO);
        templateEntity = templateRepository.save(templateEntity);
        return templateConverter.convertToDto(templateEntity);
    }

    @Override
    public TemplateDTO getTemplate(String pageName) throws Exception {
        TemplateEntity p =  templateRepository.findOneByName(pageName);
        if (p.getId() == null){
            throw new Exception("NOT FOUND");
        }
        return templateConverter.convertToDto(p);
    }
}
