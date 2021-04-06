package com.micgoo.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ProviderHystrixService {

    public String paymentInfo_OK(Long id){
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK, id" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentInfo_TimeOut(Long id){

        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK, id" + id + "耗时"+timeout+"秒";
    }

    public String paymentInfo_TimeOut_Handler(Long id){

        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK, id" + id + "服务器繁忙,请稍后重试";
    }
}
