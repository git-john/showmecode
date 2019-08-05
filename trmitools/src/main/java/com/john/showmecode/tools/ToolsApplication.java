package com.john.showmecode.tools;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

/**
 * @Author: kangq
 * @Date: 2019/8/2 18:42
 */
@SpringBootApplication
public class ToolsApplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(ToolsApplication.class, args);
        doSsh();
    }

    private static void doSsh() throws Exception{
        JSch jSch = new JSch();
        Session session = jSch.getSession("root","68.4.50.206",22);
        session.setPassword("WHZAdmin2019");
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(60000);
        session.connect(15000);
        System.out.println("sesson connect successful!");
    }
}
