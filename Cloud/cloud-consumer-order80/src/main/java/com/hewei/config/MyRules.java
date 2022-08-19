package com.hewei.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
*
* 该类的加载作用是为了配置在客户端中进行的负载均衡配置。
* 1. 不要放在ComponentScan扫描包下。
* 2. 需要将该类注入到客户端启动类的注解当中 @RibbonClient
* */
@Configuration
public class MyRules {

    @Bean
    public IRule getIrule(){

        return new RandomRule();

    }

}