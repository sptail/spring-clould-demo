package com.micgoo.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class ConsumerOpenFeignHystrixFallBck implements ConsumerOpenFeignHystrix{
    @Override
    public String paymentInfo_OK(Long id) {
        return "---------服务异常--------";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "---------服务超时--------";
    }
}
