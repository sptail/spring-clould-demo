package com.micgoo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalance{

    //记录访问次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 轮询算法
     * @param serviceInstances 服务实例列表
     * @return 某个服务实例
     */
    private final ServiceInstance roundRobinRule(List<ServiceInstance> serviceInstances){
        int current = 0;
        int next = 0;
        //自旋锁
        for(;;){
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            if(this.atomicInteger.compareAndSet(current, next)){
                break;
            }
        }
        int index = next % serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }

    /**
     * 随机
     * @param serviceInstances 服务实例列表
     * @return 某个服务实例
     */
    private final ServiceInstance randomRule(List<ServiceInstance> serviceInstances){
        if (serviceInstances == null || serviceInstances.size() == 0){
            return null;
        }
        int next = ThreadLocalRandom.current().nextInt(serviceInstances.size());
        return serviceInstances.get(next);
    }

    /**
     * 根据访问次数计算下标以实现轮训
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance initInstance(List<ServiceInstance> serviceInstances) {

        //轮询
        //return roundRobinRule(serviceInstances);
        //随机
        return randomRule(serviceInstances);
    }
}
