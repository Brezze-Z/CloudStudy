package com.hewei.cloud;

import com.hewei.config.MyRules;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/*
*
* @Author : 周赫威
* @Date ： 2022年8月13日
* 注册Eurka客户端
*
* */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRules.class)
public class ConsumerMain {

    public static void main(String[] args) {


        SpringApplication.run(ConsumerMain.class,args);

        System.out.println("~ 客户端口启动成功 ~");

    }
}
