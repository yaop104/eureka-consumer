package com.yao;

import com.yao.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaoping on 2018/6/6.
 */
@RestController
public class ConsummerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = {RequestMethod.GET})
    public String helloConsumer(){
        return helloService.helloService();
    }
}
