package com.hewei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*
* @Author : 周赫威
* @Date ： 2022年8月13日
*
* */
@SpringBootApplication
public class ConsumerMain {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerMain.class,args);

        System.out.println("~ 客户端口启动成功 ~");

    }
}
