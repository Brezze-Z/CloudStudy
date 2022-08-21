package com.hewei.cloud.service.impl;

import com.hewei.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "runTestAboutHystrixErrHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String getPaymentInfo_Err(Integer id) {
        int second = 10;
        long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
       return "当前超时为：" + Thread.currentThread().getName() + "|" +"paymentID" + "=" + id + "✿✿ヽ(°▽°)ノ✿"+ "|" + serverPort;
    }

    /*
    *
    * Hystrix的服务降级方法。
    * */
    public String runTestAboutHystrixErrHandler(Integer id){

        return "您的访问已经降级" + "|" + "✿✿ヽ(°▽°)ノ✿" + "|" + serverPort +"|"+id + "~~";

    }


}
