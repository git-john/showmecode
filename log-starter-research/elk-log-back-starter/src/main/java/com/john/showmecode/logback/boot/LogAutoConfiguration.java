package com.john.showmecode.logback.boot;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: kangq
 * @Date: 2019/6/20 19:08
 */
@Configuration
@EnableConfigurationProperties(LogbackProperties.class)
public class LogAutoConfiguration {

    private LogbackProperties logbackProperties;

    @Bean
    LogAdvice newLogAdvice(){
        return new LogAdvice();
    }
}
