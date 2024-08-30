package com.example.demo.store;

import com.example.demo.interceptor.Globallinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class IntercepConfig implements WebMvcConfigurer {
    @Autowired
    Globallinterceptor globallinterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globallinterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/rest/**","/admin/**","/assets/**");
    }
}
