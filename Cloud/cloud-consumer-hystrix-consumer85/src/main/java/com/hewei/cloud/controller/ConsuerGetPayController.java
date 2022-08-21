package com.hewei.cloud.controller;

import com.hewei.cloud.service.PostPayment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@DefaultProperties(defaultFallback = "getErrInfoAllHandler")
@RestController
@Slf4j
public class ConsuerGetPayController {

    @Resource
    private PostPayment postPayment;

    @Value("${server.port}")
    private String serverPort;


    /*客户端发送的正确请求*/
    @GetMapping("/consumer/getOkInfo/{id}")
    public String getOkInfo(@PathVariable(name = "id")Integer id){

        log.info(postPayment.getProviderOkInfo(id));
        return postPayment.getProviderOkInfo(id);

    }

    /*客户端发送的错误请求*/
    /*服务降级配置*/
    @HystrixCommand(defaultFallback = "getErrInfoHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("/consumer/getErrInfo/{id}")
    public String getErrInfo(@PathVariable(name = "id")Integer id){

        //  测试响应失败条件 --> 响应暂停5s。
        try { TimeUnit.SECONDS.sleep(5); }catch (Exception e){ e.printStackTrace(); }

        String result = postPayment.getProviderErrInfo(id);

        log.info(result);
        return result;

    }

    /* 如果需要使用服务降级，则需要在当前的方法中增加 @HystrixCommand 注解  */
    @HystrixCommand
    @GetMapping("/consumer/getErrInfoTwo/{id}")
    public String getErrInfoTest(@PathVariable(name = "id")Integer id){

        try { TimeUnit.SECONDS.sleep(5); }catch (Exception e){ e.printStackTrace(); }
        String result = postPayment.getProviderErrInfo(id);
        log.info(result);
        return result;

    }

    /*服务降级方法  --> ||  /consumer/getErrInfo/{id} ||  指定的Url路径   */
    public String getErrInfoHandler(){
        return serverPort + "| ✿✿ヽ(°▽°)ノ✿" + "当前consumer响应失败";
    }

    /*默认整体的服务降级方法*/
    public String getErrInfoAllHandler(){
        return serverPort + "| ✿✿ヽ(°▽°)ノ✿" + "consumer响应失败" + "| ✿✿ヽ(°▽°)ノ✿" ;
    }

}
