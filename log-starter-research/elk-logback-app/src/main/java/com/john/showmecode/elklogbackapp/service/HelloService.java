package com.john.showmecode.elklogbackapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: kangq
 * @Date: 2019/6/21 15:53
 */
@Service
public class HelloService {

    @Autowired
    HttpServletRequest request;

    public void doHello(){
        String name = request.getParameter("name");
        System.out.println("name is:" + name);
        System.out.println("do hello here...");
    }
}
