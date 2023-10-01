package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<TemplateEntity, Long> {
    TemplateEntity findOneByName(String pageName);
}
