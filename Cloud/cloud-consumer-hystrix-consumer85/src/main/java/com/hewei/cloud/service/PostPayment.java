package com.hewei.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT")
public interface PostPayment {

    @GetMapping("/hystrix/indexok/{id}")
    String getProviderOkInfo(@PathVariable(name = "id") Integer id);

    @GetMapping("/hystrix/indexerr/{id}")
    String getProviderErrInfo(@PathVariable(name = "id")Integer id);

}
