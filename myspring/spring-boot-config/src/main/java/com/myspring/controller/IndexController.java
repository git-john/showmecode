package com.myspring.controller;

import com.myspring.bean.BlogProperties;
import com.myspring.bean.ConfigBean;
import com.myspring.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/")
    String index(){
        StringBuilder sb = new StringBuilder();
        sb.append(configBean.getName());
        sb.append(">>");
        sb.append(configBean.getTitle());
        sb.append(">>");
        sb.append(configBean.getWholeTitle());
        sb.append(">>");
        sb.append(testConfigBean.getName());
        sb.append(":");
        sb.append(testConfigBean.getAge());

        return sb.toString();
    }
}
