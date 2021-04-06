package com.micgoo.springcloud.controller;


import com.micgoo.springcloud.entities.CommonResult;
import com.micgoo.springcloud.lb.LoadBalance;
import com.micgoo.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class ConsumerController {

    private static String PAYMENT_URL = "http://PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    LoadBalance loadBalance;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        return paymentService.getPaymentById(id);
//        //负载均衡获取请求地址
//        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-SERVICE");
//        ServiceInstance serviceInstance = loadBalance.initInstance(instances);
//        URI uri = serviceInstance.getUri();
//
//        return restTemplate.getForObject(uri+"/payment/get/"+id, CommonResult.class);
    }
}
