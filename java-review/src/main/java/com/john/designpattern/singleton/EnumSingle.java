package com.john.designpattern.singleton;

/**
 * effective java 推荐使用：
 * 1. 写法简单
 * 2. 枚举自己处理序列化： 对枚举的序列化机制，java规范禁用了writeObject, readObject等方法。对于实现了serializable接口的类，readObject读出来的是一个新对象。
 * 3. 线程安全的： 因为反编译可以看到里面的枚举变量都是static的，而jvm里面：java类的加载和初始化过程都是线程安全的，是有jdk保证的。
 * 安卓平台并不推荐：Enums often require more than twice as much memory as static constants. You should strictly avoid using enums on Android.
 * 需要jdk1.5以上， 但是现在都java12了，没什么问题。
 */
public enum  EnumSingle {

    INSTANCE;

    public void printHello(){
        System.out.println("hello world");
    }
}
