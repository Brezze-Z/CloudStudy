package com.hewei.cloud.controller;

import com.hewei.cloud.common.CommonResult;
import com.hewei.cloud.entity.Payment;
import com.hewei.cloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @RequestMapping(value = "/payment/creat",method = RequestMethod.POST)
    public CommonResult getCreatTest(Payment payment){

        int result = paymentService.insetPayment(payment.getSerial());

        log.info("****** 当前的插入结果 "+ result);

        if (result >0){
            return new CommonResult(200,"插入数据成功",result);

        }else {

            return new CommonResult(404,"插入数据失败",result);
        }

    }

    @RequestMapping(value = "/payment/select/{id}",method = RequestMethod.GET)
    public CommonResult getSelectTest(@PathVariable(value = "id") Long id){

        Payment result = paymentService.selById(id);

        log.info("****** 当前的插入结果 "+ result);

        if (result != null){
            return new CommonResult(200,"查询数据成功",result);

        }else {

            return new CommonResult(404,"查询数据失败",result);
        }

    }

}
