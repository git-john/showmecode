package com.john.javacore;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 输入一个字符串，去掉重复的字符，并按ASCII值排序
 */
public class RemoveDuplicateChar {

    public static void m2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一行字符串");
        String str = sc.nextLine();
        String s = ""; //新建一个数组保存字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); //取出字符串中的字符数
            if(s.indexOf(c) == -1 ) { //判断新建数组中是否含有某个字符
                s += c;
            }
        }
        char[] newchars = s.toCharArray();
        Arrays.sort(newchars);
        System.out.println(new String(newchars));
    }

    public static void byTreeSet(){
        Scanner scanner = new Scanner(System.in);
        String originStr = scanner.nextLine();
        char[] charArray = originStr.toCharArray();
        Set<String> treeSet = new TreeSet();
        for(char c : charArray){
            treeSet.add(c+"");
        }

        StringBuilder sb = new StringBuilder();
        for(String temp : treeSet){
            sb.append(temp);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        m2();
    }
}
