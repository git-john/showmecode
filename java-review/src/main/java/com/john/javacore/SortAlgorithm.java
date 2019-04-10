package com.john.javacore;


import com.sun.istack.internal.NotNull;

import java.util.Arrays;


//参考：https://www.cnblogs.com/guoyaohua/p/8600214.html

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
    public static void bubbleSort(@NotNull int[] nums){
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<nums.length-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }

    //选择排序： 找出最小数的索引放到排序序列的起始位置，再从剩余数组里面找最小数放到排序序列的末尾，当剩余数组为1的时候即结束
    public static void selectionSort(int nums[]){
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
    }

    //插入排序：对于未排序数据，在已排序序列中从后向前扫描，找到对应位置后插入数据
    public static void insertSort(int[] nums){
        int current;
        for(int i=0; i<nums.length-1; i++){
            current = nums[i+1];
            int preindex = i;
            while (preindex>=0 && current<nums[preindex]){
                nums[preindex+1] = nums[preindex];
                preindex--;
            }
            nums[preindex+1] = current;
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    //--------- 归并排序start
    /**
     * 归并排序
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array){
        if(array.length<2) return array;

        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid); //取值范围为[from, to)
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right){
        int i=0,j=0;
        int newLength = left.length + right.length;
        int[] result = new int[newLength];
        for(int index=0; index<newLength; index++){
            if(i>=left.length)
                result[index] = right[j++];
            else if(j>=right.length)
                result[index] = left[i++];
            else if(left[i]<right[j])
                result[index] = left[i++];
            else
                result[index] = right[j++];
        }
        return result;
    }
    //--------- 归并排序end

    //--------- 快速排序start
    /**
     * 快速排序，找一个基准数使得左边的都比他小，右边的都比他大
     * @param array
     * @return
     */
    public static void quickSort(int[] array){
        qsort(array, 0, array.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }

    //填坑法
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴大的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
    //--------- 快速排序end

    public static void main(String[] args) {
        int[] nums = new int[]{3,9,5,2,8,6,7,15,10};
        quickSort(nums);
        for(int i : nums){
            System.out.printf("%d,", i);
        }

    }
}
