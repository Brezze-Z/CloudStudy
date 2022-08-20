package com.hewei.cloud.service;

import com.hewei.cloud.common.CommonResult;
import com.hewei.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    /*
    * 在这一部分干的事情是，代替了RestTemplet发送请求，直接实现这个接口即可。
    *
    * */
    @GetMapping(value = "/payment/select/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/creat")
    CommonResult getCreatePayResult(Payment payment);

    // 延迟三秒访问
    @GetMapping(value = "/payment/stop")
    CommonResult getThreeSec();


}
