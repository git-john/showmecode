package com.john.showmecode.logback.boot;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: kangq
 * @Date: 2019/6/21 11:11
 */
@Aspect
public class LogAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Boolean monitorStatus ;

    @Autowired
    private LogbackProperties logbackProperties;

    @PostConstruct
    public void init() {
        //获取开关信息
        logger.info("---日志切面 初始化--- 全局开关："+logbackProperties.isPointCutActive());
        this.monitorStatus=logbackProperties.isPointCutActive();
    }

    @Pointcut("execution(* com..*..*Controller.*(..))")
    public void controllerMethodPointCut(){
    }

    @Around(value = "@annotation(com.john.showmecode.logback.annotation.LogAnnotation)")
    public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
        long l = System.currentTimeMillis();
        logger.info("方法执行前 ----------------" + Thread.currentThread().getName());
        logger.info("执行编号："+l);
        try {
            Object object = joinPoint.proceed();
            logger.info("方法执行后 ++++++++++++++响应时间为: " + (System.currentTimeMillis() - l));
            logger.info("执行编号："+l);

            return object;
        } catch (Exception e) {
            throw e;
        } finally {
        }

    }

    @Around(value = "controllerMethodPointCut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        if(monitorStatus){
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            //请求编号记忆
            long start=System.currentTimeMillis();
            /* 打印请求地址及参数 */
            logger.info("请求开始，请求地址："+request.getRequestURL()+",请求编号"+start);
            //类名  //方法名
            Class<?> aClass = joinPoint.getTarget().getClass();
            String name = joinPoint.getSignature().getName();
            logger.info("类名称："+aClass+" ,方法名称："+name);

            StringBuilder sb = new StringBuilder();
            Enumeration paramNames = request.getParameterNames();
            while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();
                sb.append(paramName+"="+request.getParameter(paramName) + "&");
            }


//            Map<String, String[]> paramMap = request.getParameterMap();
//
//            String queryString = request.getQueryString();
//            Object[] args = joinPoint.getArgs();
//            String params = "";
//            //获取请求参数集合并进行遍历拼接
//            if(args.length>0){
//                if("POST".equals(request.getMethod())){
//                    Object object = args[0];
//                    Map map = getKeyAndValue(object);
//                    params = JSONObject.toJSONString(map);
//                }else if("GET".equals(request.getMethod())){
//                    params = queryString;
//                }
//            }

            logger.info("请求参数："+sb);
            Object result = joinPoint.proceed();
            JSONObject jsonObject = new JSONObject();
            logger.info("请求结束，本次请求时间："+(System.currentTimeMillis()-start)+" && 返回值：" + jsonObject.toJSONString(result)+",请求编号"+start);
            return result;
        }else {
            return  joinPoint.proceed();
        }
    }

//    public static Map<String, Object> getKeyAndValue(Object obj) {
//        Map<String, Object> map = new HashMap<>();
//        // 得到类对象
//        Class userCla = (Class) obj.getClass();
//        /* 得到类中的所有属性集合 */
//        Field[] fs = userCla.getDeclaredFields();
//        for (int i = 0; i < fs.length; i++) {
//            Field f = fs[i];
//            f.setAccessible(true); // 设置些属性是可以访问的
//            Object val = new Object();
//            try {
//                val = f.get(obj);
//                // 得到此属性的值
//                map.put(f.getName(), val);// 设置键值
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return map;
//    }


}
