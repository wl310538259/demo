package com.demo.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by wanglei on 2017/5/23.
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CounterService counterService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    private String index() {
        //counterService.increment("didispace.hello.count");
        //System.out.println("Hello World");
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return "Hello World";
        //return "";
    }
}
