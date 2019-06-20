package com.john.showmecode.elklogbackapp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kangq
 * @Date: 2019/6/20 18:52
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/helloworld")
    public String helloWorld(){
        logger.info("============= hello world ============");
        return "hello world";
    }
}
