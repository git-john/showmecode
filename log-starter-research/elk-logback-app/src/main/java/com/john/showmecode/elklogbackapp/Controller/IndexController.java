package com.john.showmecode.elklogbackapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kangq
 * @Date: 2019/6/20 18:52
 */
@RestController
public class IndexController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "hello world";
    }
}
