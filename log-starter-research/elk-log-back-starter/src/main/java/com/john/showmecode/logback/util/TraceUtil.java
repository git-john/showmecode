package com.john.showmecode.logback.util;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * @Author: kangq
 * @Date: 2019/7/11 14:06
 */
public class TraceUtil {
    public static void traceStart() {
//        ThreadContext.init();
        String traceId = generateTraceId();
        MDC.put("traceId", traceId);
//        ThreadContext.putTraceId(traceId);
    }

    public static void traceEnd() {
        MDC.clear();
        ThreadContext.clean();
    }

    /**
     * 生成跟踪ID
     *
     * @return
     */
    private static String generateTraceId() {
        return UUID.randomUUID().toString();
    }
}
