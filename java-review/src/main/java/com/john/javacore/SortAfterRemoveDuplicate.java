package com.john.javacore;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * 描述: 用户输入有符号整型数组（十进制），去掉重复值后，按照升序输出整型数组（十进制）。
 *     输入: 整数N，表示数组的个数；N个整数，整数之间以空格隔开
 *     输出: 去掉重复后，按照升序输出数组
 *     样例输入:4 6 3 3 9
 *     样例输出:3 4 6 9
 */
public class SortAfterRemoveDuplicate {

    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组个数:");
        String amount = scanner.nextLine();

        System.out.println("请输入整型数组，以空格隔开:");
        String numbers = scanner.nextLine();
        String[] numberArray = numbers.split(" ");
        int[] intArray = Arrays.stream(numberArray).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();

        //使用选择排序，将最小的插入前面已排好的序列并打印，如果与前一个元素重复， 不打印
        for(int i=0; i<Integer.parseInt(amount); i++){
            int minIndex = i;
            for(int j=i+1; j<intArray.length; j++){
                if(intArray[minIndex] > intArray[j]){
                    minIndex = j;
                }
            }
            int temp = intArray[minIndex];
            intArray[minIndex] = intArray[i];
            intArray[i] = temp;

            if(i == 0){
                sb.append(intArray[i]);
                sb.append(",");
            }else {
                if(intArray[i]>intArray[i-1]){
                    sb.append(intArray[i]);
                    sb.append(",");
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean isValidInteger(String value){
        try{
            int amount = Integer.parseInt(value);
            if(amount>0) return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        solution();
    }
}
