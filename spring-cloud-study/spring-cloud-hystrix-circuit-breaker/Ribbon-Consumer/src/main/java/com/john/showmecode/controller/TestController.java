package com.john.showmecode.controller;

import com.john.showmecode.domain.User;
import com.john.showmecode.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: kangq
 * @Date: 2019/6/17 19:12
 */
@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("testRequestMerge")
    public void testRequerstMerge() throws InterruptedException, ExecutionException {
        Future<User> f1 = userService.findUser(1L);
        Future<User> f2 = userService.findUser(2L);
        Future<User> f3 = userService.findUser(3L);
        f1.get();
        f2.get();
        f3.get();
        Thread.sleep(200);
        Future<User> f4 = userService.findUser(4L);
        f4.get();
    }


    @GetMapping("user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
