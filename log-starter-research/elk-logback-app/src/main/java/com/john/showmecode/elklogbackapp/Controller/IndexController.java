package com.john.showmecode.elklogbackapp.Controller;

import com.john.showmecode.elklogbackapp.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: kangq
 * @Date: 2019/6/20 18:52
 */
@RestController
public class IndexController {

    @Autowired
    HelloService helloService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/helloworld")
    public String helloWorld(){
        logger.info("============= hello world ============");
        return "hello world";
    }

    @GetMapping("/helloAop")
    public String helloAop(HttpServletRequest request){
        helloService.doHello();
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return "name is: " + name + " && age is : " + age;
    }

}
