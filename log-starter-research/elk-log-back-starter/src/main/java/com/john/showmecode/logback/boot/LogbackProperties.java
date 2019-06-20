package com.john.showmecode.logback.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: kangq
 * @Date: 2019/6/20 18:26
 */

@ConfigurationProperties(prefix = "logback")
public class LogbackProperties {

    private String logFilePath;

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }
}
