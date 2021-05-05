package com.eplusing.demo1200.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private MicroServiceRpcImpl microServiceRpc;

    @PostMapping("/test")
    public String test(@RequestBody String req) {
        System.out.println("hystrix收到的请求:" + req);

        req = "hystrix service invoke microserver " + req;
        System.out.println("hystrix发出的请求:" + req);

        String rspData = microServiceRpc.rpc(req);

        System.out.println("hystrix收到的返回:" + rspData);

        return rspData;
    }

}
