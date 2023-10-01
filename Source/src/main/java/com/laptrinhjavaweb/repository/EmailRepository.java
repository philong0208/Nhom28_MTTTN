package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
    EmailEntity findByEmail(String email);
}
