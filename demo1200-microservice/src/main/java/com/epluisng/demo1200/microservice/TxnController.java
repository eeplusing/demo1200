package com.epluisng.demo1200.microservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo1200/microservice")
public class TxnController {

    @PostMapping("transaction")
    public String transaction(String req) {
        System.out.println(req);
        return "收到请求参数：" + req;
    }
}
