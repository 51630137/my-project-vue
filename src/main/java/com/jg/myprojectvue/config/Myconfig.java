package com.jg.myprojectvue.config;

import com.jg.myprojectvue.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
