package com.hewei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
*主程序启动类： Eureka客户端启动类。
*@Author： Herbert
*@Data: 2022年8月12日09:27:44
* */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain {

    // 主要启动类需要填写Main方法才可以进行正常的运行。
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain.class,args);

        System.out.println("~ 服务器启动成功 ~");

    }


}
