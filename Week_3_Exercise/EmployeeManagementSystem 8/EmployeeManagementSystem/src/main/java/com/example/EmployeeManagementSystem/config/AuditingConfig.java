package com.example.EmployeeManagementSystem.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // Replace with actual user logic in a real application
        return () -> Optional.of("systemUser");
    }
}
