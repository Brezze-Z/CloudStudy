package com.hewei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
*
* @Author ：周赫威
* @Data ： 2022年8月14日
* @func ： 主启动文件，用于主启动的目录。
* */
@SpringBootApplication
// 标识 Eurka注册中心。
@EnableEurekaServer
public class EurekaMain {

    public static void main(String[] args) {

        SpringApplication.run(EurekaMain.class,args);
        System.out.println("Eureka:7001"+"✿✿ヽ(°▽°)ノ✿");

    }

}
