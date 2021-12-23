package com.example.demo.config;

import com.example.demo.filter.ProxyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {

    @Bean
    public ProxyFilter proxyFilter(){
        return new ProxyFilter();
    }
}
