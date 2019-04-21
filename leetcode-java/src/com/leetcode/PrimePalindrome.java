package com.leetcode;

import java.util.Scanner;


/**
 * Find the smallest prime palindrome greater than or equal to N
 * 1<=N<=10^8
 * 数学知识：所有长度为偶数的回文数字一定是 11 的倍数
 */
public class PrimePalindrome {

    public static int findPrimePalindrome(int number){
        if(number>=8 && number<=11) return 11;

        // method 1
//        for(int i=number+1; i<Math.pow(10,8); i++){
//            if(isPalindrome(i) && isPrime(i)) return i;
//        }

        //method 2
        for(int i=1; i<Math.pow(10,5); i++){  //可优化到10^5
            String s = i+"";
            String revers = new StringBuffer(s).reverse().toString();
            String result = s + revers.substring(1,revers.length());
            System.out.println(">>>>" + result);
            int x = Integer.parseInt(result);
            if(isPrime(x) && x>number) return Integer.parseInt(result);
        }
        return 0;
    }

    /**
     * 判断是否回文数。 将整个数取反后跟原来的数比较
     * @param number
     * @return
     */
    public static boolean isPalindrome(int number){
        int sum = 0;
        int x = number;
        while (x>0){
            sum = sum * 10 + x%10;
            x /= 10;
        }
        return number == sum;
    }

    public static boolean isPrime(int number){
        if (number < 2 || number%2 == 0) return number == 2;
        double limit = Math.sqrt(number);
        for(int i=3; i<=limit; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数字， 我将算出下一个回文质数");
        Scanner scanner = new Scanner(System.in);
        while (true){
            int number = scanner.nextInt();
            System.out.println("after sqrt is: "+Math.sqrt(number));
            if(number == 0) break;
            System.out.println(findPrimePalindrome(number));
        }
    }
}
