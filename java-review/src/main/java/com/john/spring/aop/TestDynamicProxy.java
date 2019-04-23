package com.john.spring.aop;

public class TestDynamicProxy {

    public static void main(String[] args) {

        IUserDao proxy = (IUserDao) new ProxyFactory(new UserDao()).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
        proxy.find();
    }
}
