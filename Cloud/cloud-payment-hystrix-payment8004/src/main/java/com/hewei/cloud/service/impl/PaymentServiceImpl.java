package com.hewei.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.hewei.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //服务熔断保护
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),/* 是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 超时处理
    })
    public String paymentCircuitBreaker(@PathVariable(name = "id")Integer id){

        if (id<0){
            throw new RuntimeException("该服务已经熔断！"+"\t" + "✿✿ヽ(°▽°)ノ✿");
        }
        else {

            String serialNumber = IdUtil.simpleUUID();
            return Thread.currentThread().getName()+"\t" + "✿✿ヽ(°▽°)ノ✿" + "调用成功，流水号: " + serialNumber;

        }

    }

    // 服务熔断响应
    public String paymentCircuitBreakerFallback(@PathVariable(name = "id") Integer id){
        return "已经启动了熔断机制！" + "|" + "✿✿ヽ(°▽°)ノ✿" + "|";
    }

}
