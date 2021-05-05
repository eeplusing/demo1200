package com.epluisng.demo1200.microservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo1200/microservice")
public class TxnController {

    @PostMapping("/transaction")
    public String transaction(@RequestBody String req) {
        System.out.println(req);
        return "这是microserver/transaction的返回" + req;
    }
}
