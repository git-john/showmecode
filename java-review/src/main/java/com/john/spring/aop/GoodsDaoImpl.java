package com.john.spring.aop;

public class GoodsDaoImpl implements IGoodsDao {

    @Override
    public void addGoods() {
        System.out.println("add goods");
    }

    @Override
    public void deleteGoods() {
        System.out.println("delete goods");
    }
}
