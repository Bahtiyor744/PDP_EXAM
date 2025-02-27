package com.example.pdp_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Barcha endpointlarga CORS ruxsat berish
                .allowedOrigins("*") // Barcha domenlarga ruxsat berish (xavfsizlik uchun cheklash tavsiya etiladi)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Ruxsat etilgan HTTP metodlari
                .allowedHeaders("*") // Barcha headerlarga ruxsat berish
                .allowCredentials(true); // Cookie va auth headerlarni qo'llab-quvvatlash
    }
}
