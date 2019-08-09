package com.john.showmecode.javacore;

/**
 * @Author: kangq
 * @Date: 2019/8/9 9:44
 */
public class EqualsIssue {

    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }
}
