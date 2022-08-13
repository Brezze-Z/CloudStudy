package com.hewei.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
*
* 配置RestTemplate Bean。
* 功能：对于Rest进行接口开发和使用。
*
* */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();

    }
    
}
