package com.micgoo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {

    ServiceInstance initInstance(List<ServiceInstance> serviceInstances);
}
