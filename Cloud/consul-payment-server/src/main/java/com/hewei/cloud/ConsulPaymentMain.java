package com.hewei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
*
* Consul 的支付模块主启动程序
*
*
* */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentMain.class,args);
    }
}
