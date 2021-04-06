package com.micgoo.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PROVIDER-HYSTRIX-SERVICE", fallback = ConsumerOpenFeignHystrixFallBck.class)
public interface ConsumerOpenFeignHystrix {

    @GetMapping("/getProvider/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id);

    @GetMapping("/getProvider/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id);
}
