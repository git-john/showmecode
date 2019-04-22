package com.john.designpattern.singleton;

public class SingletonStaticInner {

    private static class Holder{
        private static SingletonStaticInner instance = new SingletonStaticInner();
    }

    private SingletonStaticInner(){}

    public SingletonStaticInner getInstance(){
        return Holder.instance;
    }
}
