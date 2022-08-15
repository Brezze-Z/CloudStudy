package com.hewei.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
*
* 配置RestTemplate Bean。
* 功能：1. 对于Rest进行接口开发和使用。
*      2. 通过RestTempleat 开启负载均衡。
*
* */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();

    }
    
}
