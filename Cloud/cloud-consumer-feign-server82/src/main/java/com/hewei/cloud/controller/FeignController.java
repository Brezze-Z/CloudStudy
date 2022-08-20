package com.hewei.cloud.controller;

import com.hewei.cloud.common.CommonResult;
import com.hewei.cloud.entity.Payment;
import com.hewei.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/select/{id}")
    public CommonResult<Payment> getPaymentInfo(@PathVariable(value = "id") Long id){

       return paymentService.getPaymentById(id);

    }

    @GetMapping(value = "/consumer/create")
    public CommonResult getCreateResult(Payment payment){

        return paymentService.getCreatePayResult(payment);
    }

    /*
    * Consumer端：Feigen端口访问
    * 延时访问策略
    * */
    @GetMapping(value = "/consumer/stop")
    public CommonResult getCommonResult(){

        return paymentService.getThreeSec();

    }

}
