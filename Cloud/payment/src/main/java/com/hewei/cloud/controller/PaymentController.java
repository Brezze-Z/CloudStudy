package com.hewei.cloud.controller;

import com.hewei.cloud.common.CommonResult;
import com.hewei.cloud.entity.Payment;
import com.hewei.cloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @RequestMapping(value = "/payment/creat",method = RequestMethod.POST)
    public CommonResult getCreatTest(@RequestBody Payment payment) throws Exception{


        CommonResult commonResult = null;
        int result;

        // 开启查询。
        try {

            result = paymentService.insetPayment(payment.getSerial());

            if (result > 0) {

                commonResult =  new CommonResult(200, "插入数据成功", result);

            } else {

                commonResult = new CommonResult(404, "插入数据失败", result);
            }

        }catch (Exception e){
            result = 0;
            commonResult = new CommonResult(404, "插入数据异常", result);
            e.printStackTrace();
        }

        log.info("****** 当前的新增结果 ：" + result);
        return commonResult;

    }

    @RequestMapping(value = "/payment/select/{id}",method = RequestMethod.GET)
    public CommonResult getSelectTest(@PathVariable(value = "id") Long id){

        Payment result = (Payment) paymentService.selById(id);

        log.info("****** 当前的插入结果 "+ result);

        if (result != null){

            return new CommonResult(200,"查询数据成功",result);

        }else {

            return new CommonResult(404,"查询数据失败",result);

        }

    }

}
