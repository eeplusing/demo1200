package com.eplusing.demo1200.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private static String rpcServiceName = "microservice";

    @PostMapping("/test")
    public String test(@RequestBody String req) {
        System.out.println(req);

        List<ServiceInstance> serviceInstanceList =  this.discoveryClient.getInstances(rpcServiceName);
        return "收到请求参数：" + req;
    }
}
