package com.hewei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*主要启动类
*@Author： zhou
*@Data: 2022年8月12日09:27:44
* */
@SpringBootApplication
public class PaymentMain {

    // 主要启动类需要填写Main方法才可以进行正常的运行。
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain.class,args);
        System.out.println("启动成功！！");

    }

}
