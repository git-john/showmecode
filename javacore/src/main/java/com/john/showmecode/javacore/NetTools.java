package com.john.showmecode.javacore;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @Author: kangq
 * @Date: 2019/8/6 15:40
 */
@Slf4j
public class NetTools {

    protected static void printInterfaces() throws Exception{
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            NetworkInterface ni = interfaces.nextElement();
            Enumeration<InetAddress> ias = ni.getInetAddresses();
            while (ias.hasMoreElements()){
                InetAddress ia = ias.nextElement();
                log.info("ip:{}, is loop:{}, is site local: {}",ia.getHostAddress(), ia.isLoopbackAddress(), ia.isSiteLocalAddress());
            }
        }
    }

    /**
     * Error:java: Compilation failed: internal java compiler error
     * 解决办法很简单：File-->Setting...-->Build,Execution,Deployment-->Compiler-->Java Compiler 设置相应Module的target bytecode version的合适版本（跟你jkd版本一致），这里我改成1.8版本的。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        printInterfaces();
    }
}
