package com.john.javacore;

import java.util.Scanner;

/**
 * 输入字符串，提取字符串串中大写字母，注意字符串中可能含有空格等其他字符
 */
public class FindCapitalChar {

    public static void extractCapital(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("****请输入字符串：\n");
        String originStr = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<originStr.length(); i++){
            if(originStr.charAt(i) >= 65 && originStr.charAt(i) <= 91){
                result.append(originStr.charAt(i));
            }
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        extractCapital();
    }
}
