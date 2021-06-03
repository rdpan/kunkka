package com.hhl.kunkka.integration.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FeignHandleInterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FeignReceiverHandleInterceptor()).addPathPatterns(new String[]{"/**"});
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignSenderHandleInterceptor();
    }
}
