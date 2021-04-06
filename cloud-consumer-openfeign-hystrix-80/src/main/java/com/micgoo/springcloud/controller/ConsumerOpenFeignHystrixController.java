package com.micgoo.springcloud.controller;

import com.micgoo.springcloud.service.ConsumerOpenFeignHystrix;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "consumer_global_fallback")
public class ConsumerOpenFeignHystrixController {

    @Resource
    ConsumerOpenFeignHystrix consumerOpenFeignHystrix;

    @GetMapping("/consumer/getProvider/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        String result = consumerOpenFeignHystrix.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/getProvider/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
//    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Long id){
        int age = 10/0;
        String result =  consumerOpenFeignHystrix.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOut_Handler(@PathVariable("id") Long id){
        return "服务异常,请稍后重试";
    }


//    //全局fallback
//    public String consumer_global_fallback(){
//        return "服务异常,请稍后重试,全局处理";
//    }
}
