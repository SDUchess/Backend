package com.example.chess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 允许跨域访问的路径
                .allowedOriginPatterns("*")  // 允许跨域访问的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 允许的HTTP方法
                .allowedHeaders("*")  // 允许的请求头
                .allowCredentials(true);  // 允许凭证
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.addAllowedOriginPattern("*"); // 允许所有请求源
        cors.addAllowedHeader("*"); // 允许所有请求头
        cors.addAllowedMethod("GET");
        cors.addAllowedMethod("POST");
        // cors.addAllowedMethod("PUT");
        // cors.addAllowedMethod("DELETE");
        cors.addAllowedMethod("OPTIONS");
        // cors.addAllowedMethod("PATCH");
        cors.setAllowCredentials(true); // 允许跨域发送cookie

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);
        return new CorsFilter(source);
    }
}
