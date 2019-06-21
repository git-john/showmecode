package com.john.showmecode.logback.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: kangq
 * @Date: 2019/6/20 18:26
 */

@ConfigurationProperties(prefix = "logback")
public class LogbackProperties {

    private String logHome;

    private String logstashIp;

    private String logstashPort;

    private boolean pointCutActive;

    public String getLogHome() {
        return logHome;
    }

    public void setLogHome(String logHome) {
        this.logHome = logHome;
    }

    public String getLogstashIp() {
        return logstashIp;
    }

    public void setLogstashIp(String logstashIp) {
        this.logstashIp = logstashIp;
    }

    public String getLogstashPort() {
        return logstashPort;
    }

    public void setLogstashPort(String logstashPort) {
        this.logstashPort = logstashPort;
    }

    public boolean isPointCutActive() {
        return pointCutActive;
    }

    public void setPointCutActive(boolean pointCutActive) {
        this.pointCutActive = pointCutActive;
    }
}
