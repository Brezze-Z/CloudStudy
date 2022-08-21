package com.hewei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
*主程序启动类： Eureka客户端启动类。
*@Author： Herbert
*@Data: 2022年8月12日09:27:44
* */
@SpringBootApplication
@EnableEurekaClient
//注解开启断路器功能（如果不使用该注解，则Hystrix无法启动该类）
@EnableCircuitBreaker
public class  HystrixBootMain8004 {
    // 主要启动类需要填写Main方法才可以进行正常的运行。
    public static void main(String[] args) {

        SpringApplication.run(HystrixBootMain8004.class,args);

        System.out.println("~ 服务器启动成功 " +"✿✿ヽ(°▽°)ノ✿");

    }

}
