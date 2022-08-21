package com.hewei.cloud.service.impl;

import com.hewei.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String serverPort;

    public String getPaymentInfo(Integer id) {
        return "当前线程为：" + Thread.currentThread().getName() + "|" +"paymentID" + "=" + id + "✿✿ヽ(°▽°)ノ✿"+ "|" + serverPort;
    }

    public String getPaymentInfo_Err(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return "当前超时为：" + Thread.currentThread().getName() + "|" +"paymentID" + "=" + id + "✿✿ヽ(°▽°)ノ✿"+ "|" + serverPort;
    }


}
