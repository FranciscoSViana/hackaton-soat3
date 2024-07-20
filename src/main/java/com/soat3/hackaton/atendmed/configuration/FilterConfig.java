package com.soat3.hackaton.atendmed.configuration;

import com.soat3.hackaton.atendmed.commons.filter.HeaderValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private HeaderValidationFilter headerValidationFilter;

    @Bean
    public FilterRegistrationBean<HeaderValidationFilter> loggingFilter() {
        FilterRegistrationBean<HeaderValidationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(headerValidationFilter);
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}