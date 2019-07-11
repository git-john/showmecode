package com.john.showmecode.logback.boot;

import com.john.showmecode.logback.LoggerFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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

    /**
     * 加入自定义filter， 使得requestWrapper可用
     * @return
     */
//    @Bean
//    public FilterRegistrationBean loggerFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setFilter(new LoggerFilter());
//        return filterRegistrationBean;
//    }
}
