package com.likelion.spring.configuration;

import com.likelion.spring.intercepter.ApplicationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private ApplicationInterceptor applicationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(applicationInterceptor);

        WebMvcConfigurer.super.addInterceptors(registry);
    }


}
