package com.micgoo.springcloud.controller;

import com.micgoo.springcloud.service.ProviderHystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    ProviderHystrixService providerHystrixService;

    @GetMapping("/getProvider/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        String result = providerHystrixService.paymentInfo_OK(id);
        System.out.println("*************result:" + result);
        return result;
    }

    @GetMapping("/getProvider/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id){
        String result =  providerHystrixService.paymentInfo_TimeOut(id);
        System.out.println("*************result:" + result);
        return result;
    }

}
