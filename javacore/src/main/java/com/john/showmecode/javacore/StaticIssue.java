package com.john.showmecode.javacore;

/**
 * @Author: kangq
 * @Date: 2019/8/9 9:41
 */
public class StaticIssue {

    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String args[]) {
        //result is 5
        System.out.println("x =" + x);
    }

    static {
        x /= 3;
    }

}
