package com.john.javacore;

import java.util.Arrays;

/**
 * 排序算法
 */
public class SortAlgorithm {

    // 对连续整数进行排序
    public static int[] sortSerialInteger(){
        int[] origin = new int[]{2,5,3,4,7,6,8};
        int[] result = new int[9];
        for(int item : origin){
            result[item] += 1;
        }

        for(int i=0; i<result.length; i++){
            if(result[i] > 0){
                System.out.print(i);
                System.out.print(",");
            }
        }
        return result;
    }

    //冒泡排序， 两两比较，将最大的数放到最后面
    public static void bubbleSort(){
        int[] nums = new int[]{3,9,5,2,8,6,7,15,10};
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<nums.length-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for(int i : nums){
            System.out.printf("%d,", i);
        }
    }

    //选择排序： 找出最小数的索引放到排序序列的起始位置，再从剩余数组里面找最小数放到排序序列的末尾，当剩余数组为1的时候即结束
    public static void selectionSort(){
        int[] nums = new int[]{3,9,5,2,8,6,7,15,10};
        for(int i=0; i<nums.length; i++){
            int minIndex = i;
            for(int j=i; j<nums.length; j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        for(int i : nums){
            System.out.printf("%d,", i);
        }
    }

    public static void main(String[] args) {
        selectionSort();
    }
}
