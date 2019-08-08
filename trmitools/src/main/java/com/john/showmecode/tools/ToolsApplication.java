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

    /**
     * 需要目标服务器的ssh配置允许，否则auth fail。
     * PermitRootLogin 设置成yes
     * GSSAPIAuthentication 修改为 no
     * UseDNS yes 修改为 no
     * StrictModes设置成no
     * @throws Exception
     */
    private static void doSsh() throws Exception{
        JSch jSch = new JSch();
        Session session = jSch.getSession("root","xx.xx.xx.xx",22);
        session.setPassword("sdfdsa");
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(60000);
        session.connect(15000);
        System.out.println("sesson connect successful!");
    }
}
