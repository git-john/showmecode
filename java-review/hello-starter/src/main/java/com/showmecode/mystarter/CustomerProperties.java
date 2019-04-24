package com.showmecode.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class CustomerProperties {

    private static final String DEFAULT_NAME = "John Kang";

    private String name = DEFAULT_NAME;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
