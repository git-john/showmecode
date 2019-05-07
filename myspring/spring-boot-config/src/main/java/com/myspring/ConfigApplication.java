package com.myspring;

import com.myspring.bean.ConfigBean;
import com.myspring.bean.TestConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApplication.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}
