package com.hewei.cloud.controller;

import com.hewei.cloud.service.PostPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class ConsuerGetPayController {

    @Resource
    private PostPayment postPayment;


    /*客户端发送的正确请求*/
    @GetMapping("/consumer/getOkInfo/{id}")
    public String getOkInfo(@PathVariable(name = "id")Integer id){

        log.info(postPayment.getProviderOkInfo(id));
        return postPayment.getProviderOkInfo(id);

    }

    /*客户端发送的错误请求*/
    @GetMapping("/consumer/getErrInfo/{id}")
    public String getErrInfo(@PathVariable(name = "id")Integer id){

        log.info(postPayment.getProviderErrInfo(id));
        return postPayment.getProviderErrInfo(id);

    }

}
