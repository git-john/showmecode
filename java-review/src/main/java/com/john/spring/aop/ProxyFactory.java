package com.john.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    // 通过反射机制来生成代理类对象
    public Object getProxyInstance(){
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        Object result = null;
                        if("find".equals(methodName)){
                            System.out.println("+++ do find...");
                            result = method.invoke(target, args);
                        }else{
                            System.out.println("开启事务。。。");
                            result = method.invoke(target, args);
                            System.out.println("关闭事务。。。");
                        }
                        return result;
                    }
                });
        return proxy;
    }

}
