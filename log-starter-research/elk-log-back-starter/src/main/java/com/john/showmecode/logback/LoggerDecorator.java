package com.john.showmecode.logback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: kangq
 * @Date: 2019/7/3 8:55
 */
public class LoggerDecorator {

//    Logger logger = LoggerFactory.getLogger(LoggerDecorator.class);

    private Logger logger;

//    String message = "{'requestId':, message:,time:,uri:, serviceid:,serverip:,clientip:}";

    private LoggerDecorator(Class<?> clazz){
        logger = LoggerFactory.getLogger(clazz);
    }

    private LoggerDecorator(Class<?> clazz, String requestId){
        logger = LoggerFactory.getLogger(clazz);
    }

    public static LoggerDecorator getLogger(Class<?> clazz){
        return new LoggerDecorator(clazz);
    }

    public void info(String var1){
        String message = formatMessage(var1);
        logger.info(message);
    }

    public void setRequestId(String requestId){
        if(StringUtils.isEmpty(requestId)){
            logger.warn("requestId cannot be empty");
            return;
        }


        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(null == requestAttributes){
            logger.warn("not a request, cannot set request id");
            return;
        }
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        MyRequestWrapper myRequestWrapper = (MyRequestWrapper) request;
        myRequestWrapper.putHeader("requestId", requestId);
    }

    private String formatMessage(String var){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        String requestId = "";
        String uri = "";
        if(null != requestAttributes){
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            MyRequestWrapper myRequestWrapper = (MyRequestWrapper) request;
            if(StringUtils.isEmpty(myRequestWrapper.getHeader("requestId"))){
                //如果为空，生成一个requestId并放入header
                myRequestWrapper.putHeader("requestId", "request-"+System.currentTimeMillis());
            }
            uri = myRequestWrapper.getRequestURI();
            requestId = myRequestWrapper.getHeader("requestId");

        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("requestId", requestId);
        jsonObject.put("uri", uri);
        jsonObject.put("message", var);
        return jsonObject.toJSONString();
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
