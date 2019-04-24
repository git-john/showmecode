package com.showmecode.mystarter;

public class CustomerService {

    private String name;

    public String findCustomer(){
        return "The Customer is " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
