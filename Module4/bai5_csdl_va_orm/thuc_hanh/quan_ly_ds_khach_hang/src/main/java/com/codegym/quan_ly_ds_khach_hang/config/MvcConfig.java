package com.codegym.quan_ly_ds_khach_hang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/templates/view/css/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/5.0.0/");
        registry.addResourceHandler("/resources/templates/view/js/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.6.0/");
        registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
    }
}