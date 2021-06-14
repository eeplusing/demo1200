package com.eplusing.demo1200.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroServiceRpcImpl {
    @Autowired
    private MicroServiceInvokeClient microServiceInvokeClient;


/*    @HystrixCommand(groupKey="UserGroup", commandKey = "GetUserByIdCommand",
            commandProperties = {
                    @HystrixProperty(name = "thread.timeout", value = "500"),
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "15000")
            },

            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "101"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.time", value = "1440")
            })*/
    public String rpc(String reqData) {
        String rspData = microServiceInvokeClient.invokeMicroService(reqData);

        System.out.println("hystrix rpc收到的返回:" + rspData);

        return rspData;
    }


    public String fallback(long id) {
        return "invoke microservice fallback";
    }
}
