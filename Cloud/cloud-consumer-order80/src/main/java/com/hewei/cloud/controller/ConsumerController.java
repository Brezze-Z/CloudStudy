package com.hewei.cloud.controller;

import com.hewei.cloud.common.CommonResult;
import com.hewei.cloud.entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/*
*
* @Author : 周赫威
* @Date ： 2022年8月13日16:40:16
* @function：客户Controller，用于访问微服务当中的其他端口
*
* */
@RestController
public class ConsumerController {

    // 创建基础的URL路径
    private static final String Payment_Url = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate = new RestTemplate();

    // 由于是客户端，大部分请求都是Get。 创建请求。
    @RequestMapping(value = "/consumer/payment/create",method = RequestMethod.GET)
    public CommonResult<Payment> create(Payment payment){
        // 通过restTemplate 来发送请求。
            return restTemplate.postForObject(Payment_Url+"/payment/creat",payment,CommonResult.class);

    }

    // 查询请求
    @RequestMapping(value = "/consumer/payment/select/{id}",method = RequestMethod.GET)
    public ResponseEntity<CommonResult> selectPayment(@PathVariable(value = "id") long id){

         return restTemplate.getForEntity(Payment_Url+"/payment/select/"+id,CommonResult.class);

    }




}
