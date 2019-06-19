package com.john.showmecode.boot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: kangq
 * @Date: 2019/6/18 16:22
 */

@ConfigurationProperties(prefix = "elkLog")
@Data
public class ElkLogProperties {

    private String requestId;
}
