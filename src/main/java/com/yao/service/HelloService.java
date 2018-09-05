package com.yao.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * Created by yaoping on 2018/6/8.
 */
@Service
public class HelloService {

    private Logger logger = Logger.getLogger(HelloService.class.getName());

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){

        long start = System.currentTimeMillis();

        String result  = restTemplate.getForEntity("http://EUREKA-PROVIDER/hello", String.class).getBody();

        long end  = System.currentTimeMillis();

        logger.info("Speed time: " + (end - start) );


        return result;
    }

    public String helloFallback(){
        return "error";
    }
}
