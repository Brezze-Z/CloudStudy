package com.hewei.cloud.controller;

import com.hewei.cloud.common.CommonResult;
import com.hewei.cloud.entity.Payment;
import com.hewei.cloud.service.impl.PaymentServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {


    @Autowired
    private PaymentServiceImpl paymentService;

    // 请求的正确方法
    @GetMapping("/hystrix/indexok/{id}")
    public String runTestAboutHystrix(@PathVariable(name = "id")Integer id){

        log.info(paymentService.getPaymentInfo(id));
        return paymentService.getPaymentInfo(id);

    }

    // 请求的错误（超时）方法 3s
    @GetMapping("/hystrix/indexerr/{id}")
    public String runTestAboutHystrixErr(@PathVariable(name = "id")Integer id){

        String result = paymentService.getPaymentInfo_Err(id);
        log.info(result);
        return result;

    }

}
