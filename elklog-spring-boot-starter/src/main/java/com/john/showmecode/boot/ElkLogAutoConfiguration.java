package com.john.showmecode.boot;

//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: kangq
 * @Date: 2019/6/18 16:21
 */

@Configuration
//@ConditionalOnClass(DefaultKaptcha.class)
@EnableConfigurationProperties(ElkLogProperties.class)
public class ElkLogAutoConfiguration {
}
