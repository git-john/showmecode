package com.john.spring.aop;

public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("save user");
    }

    @Override
    public void find() {
        System.out.println("find user");
    }
}
