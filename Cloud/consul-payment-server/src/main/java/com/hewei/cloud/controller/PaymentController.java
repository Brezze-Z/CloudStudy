package com.hewei.cloud.controller;

import com.hewei.cloud.common.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/*
*
* 支付Controller
* 用于服务注册测试
*
* */
@RestController
public class PaymentController {

    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping("/paymeny/test")
    public CommonResult getConsul(){

        String message = serverPort + ":" + UUID.randomUUID();

        return new CommonResult(200,message,null);

    }



}
