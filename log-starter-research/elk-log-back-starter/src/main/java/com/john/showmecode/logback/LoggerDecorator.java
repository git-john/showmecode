package com.john.showmecode.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: kangq
 * @Date: 2019/7/3 8:55
 */
public class LoggerDecorator {

//    Logger logger = LoggerFactory.getLogger(LoggerDecorator.class);

    private Logger logger;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    //TODO: ASYNC, request object
    //允许自定义request-id

//    String message = "{'requestId':, message:,time:,uri:, serviceid:,serverip:,clientip:}";

    private LoggerDecorator(Class<?> clazz){
        logger = LoggerFactory.getLogger(clazz);
    }

    private LoggerDecorator(Class<?> clazz, String requestId){
        logger = LoggerFactory.getLogger(clazz);
    }

    public LoggerDecorator getLogger(Class<?> clazz){
        return new LoggerDecorator(clazz);
    }

    public boolean isTraceEnabled(){
        return logger.isTraceEnabled();
    }

    public void trace(String var1){
        logger.trace(var1);
    }

    public void trace(String var1, Object var2){
        logger.trace(var1, var2);
    }

    public void trace(String var1, Object var2, Object var3){
        logger.trace(var1, var2, var3);
    }

    public void trace(String var1, Object... var2){
        logger.trace(var1, var2);
    }

    public void trace(String var1, Throwable var2){
        logger.trace(var1, var2);
    }

    public boolean isTraceEnabled(Marker var1){
        return logger.isTraceEnabled(var1);
    }

    public void trace(Marker var1, String var2){
        logger.trace(var1, var2);
    }

    public void trace(Marker var1, String var2, Object var3){
        logger.trace(var1, var2, var3);
    }

    public void trace(Marker var1, String var2, Object var3, Object var4){
        logger.trace(var1, var2, var3, var4);
    }

    public void trace(Marker var1, String var2, Object... var3){
        logger.trace(var1, var2, var3);
    }

    public void trace(Marker var1, String var2, Throwable var3){
        logger.trace(var1, var2, var3);
    }

    public boolean isDebugEnabled(){
        return logger.isDebugEnabled();
    }

    public void debug(String var1){
        logger.debug(var1);
    }

    public void debug(String var1, Object var2){
        logger.debug(var1, var2);
    }

    public void debug(String var1, Object var2, Object var3){
        logger.debug(var1, var2, var3);
    }

    public void debug(String var1, Object... var2){
        logger.debug(var1, var2);
    }

    public void debug(String var1, Throwable var2){
        logger.debug(var1, var2);
    }

    public boolean isDebugEnabled(Marker var1){
        return logger.isDebugEnabled(var1);
    }

    public void debug(Marker var1, String var2){
        logger.debug(var1, var2);
    }

    public void debug(Marker var1, String var2, Object var3){
        logger.debug(var1, var2, var3);
    }

    public void debug(Marker var1, String var2, Object var3, Object var4){
        logger.debug(var1, var2, var3, var4);
    }

    public void debug(Marker var1, String var2, Object... var3){
        logger.debug(var1, var2, var3);
    }

    public void debug(Marker var1, String var2, Throwable var3){
        logger.debug(var1, var2, var3);
    }

    public boolean isInfoEnabled(){
        return logger.isInfoEnabled();
    }

    public void setRequestId(String var1){
        response.addHeader("requestId", "request-thread-1");
    }

    public void info(String var1){
        logger.info(var1);
    }

    public void info(String var1, Object var2){
        logger.info(var1, var2);
    }

    public void info(String var1, Object var2, Object var3){
        logger.info(var1, var2, var3);
    }

    public void info(String var1, Object... var2){
        logger.info(var1, var2);
    }

    public void info(String var1, Throwable var2){
        logger.info(var1, var2);
    }

    public boolean isInfoEnabled(Marker var1){
        return logger.isInfoEnabled(var1);
    }

    public void info(Marker var1, String var2){
        logger.info(var1, var2);
    }

    public void info(Marker var1, String var2, Object var3){
        logger.info(var1, var2, var3);
    }

    public void info(Marker var1, String var2, Object var3, Object var4){
        logger.info(var1, var2, var3, var4);
    }

    public void info(Marker var1, String var2, Object... var3){
        logger.info(var1, var2, var3);
    }

    public void info(Marker var1, String var2, Throwable var3){
        logger.info(var1, var2, var3);
    }

    public boolean isWarnEnabled(){
        return logger.isWarnEnabled();
    }

    public void warn(String var1){
        logger.warn(var1);
    }

    public void warn(String var1, Object var2){
        logger.warn(var1, var2);
    }

    public void warn(String var1, Object... var2){
        logger.warn(var1, var2);
    }

    public void warn(String var1, Object var2, Object var3){
        logger.warn(var1, var2, var3);
    }

    public void warn(String var1, Throwable var2){
        logger.warn(var1, var2);
    }

    public boolean isWarnEnabled(Marker var1){
        return logger.isWarnEnabled(var1);
    }

    public void warn(Marker var1, String var2){
        logger.warn(var1, var2);
    }

    public void warn(Marker var1, String var2, Object var3){
        logger.warn(var1, var2, var3);
    }

    public void warn(Marker var1, String var2, Object var3, Object var4){
        logger.warn(var1, var2, var3, var4);
    }

    public void warn(Marker var1, String var2, Object... var3){
        logger.warn(var1, var2, var3);
    }

    public void warn(Marker var1, String var2, Throwable var3){
        logger.warn(var1, var2, var3);
    }

    public boolean isErrorEnabled(){
        return logger.isErrorEnabled();
    }

    public void error(String var1){
        logger.error(var1);
    }

    public void error(String var1, Object var2){
        logger.error(var1, var2);
    }

    public void error(String var1, Object var2, Object var3){
        logger.error(var1, var2, var3);
    }

    public void error(String var1, Object... var2){
        logger.error(var1, var2);
    }

    public void error(String var1, Throwable var2){
        logger.error(var1, var2);
    }

    public boolean isErrorEnabled(Marker var1){
        return logger.isErrorEnabled(var1);
    }

    public void error(Marker var1, String var2){
        logger.error(var1, var2);
    }

    public void error(Marker var1, String var2, Object var3){
        logger.error(var1, var2, var3);
    }

    public void error(Marker var1, String var2, Object var3, Object var4){
        logger.error(var1, var2, var3, var4);
    }

    public void error(Marker var1, String var2, Object... var3){
        logger.error(var1, var2, var3);
    }

    public void error(Marker var1, String var2, Throwable var3){
        logger.error(var1, var2, var3);
    }
}
