package com.eplusing.demo1200.hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("microservice")
public interface MicroServiceInvokeClient {

    //服务的请求路径
    @PostMapping("/demo1200/microservice/transaction")
    public String invokeMicroService(String reqData);
}
