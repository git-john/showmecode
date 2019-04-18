package com.john.javacore;

import java.util.Arrays;

public class Heap {

    static void fixDown(int[] data, int i, int n){
        int num = data[i];
        int son = i*2 + 1;
    }
    //构建小顶堆
    static void create(int[] data, int n){
        for(int i=(n-1)/2; i>=0; i--){

        }
    }

    public static void main(String[] args) {
        int[] data = { 15, 13, 1, 5, 20, 12, 8, 9, 11 };
        // 测试建堆
        create(data, data.length - 1);
        System.out.println(Arrays.toString(data));
//        // 测试删除
//        delete(data, data.length - 1);
//        delete(data, data.length - 2);
//        System.out.println(Arrays.toString(data));
//        // 测试插入
//        insert(data, 3, data.length - 2);
//        System.out.println(Arrays.toString(data));

    }
}
