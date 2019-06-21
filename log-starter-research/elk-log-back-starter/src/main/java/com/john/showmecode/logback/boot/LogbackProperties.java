package com.john.showmecode.logback.boot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: kangq
 * @Date: 2019/6/20 18:26
 */

@ConfigurationProperties(prefix = "logback")
@Data
public class LogbackProperties {

    private String logHome;

    private String logstashIp;

    private String logstashPort;
}
