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

    //堆排序 --start
    //声明全局变量，用于记录数组array的长度；
    static int len;
    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    //堆排序 --end


    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //计数排序
    public static int[] countSort(){
        int[] arr = new int[]{-1, 2, 0, 4, 3, 6, 5, 8, -2, 1, 3, 0, 3,6, 5, 2};
        //找出min与max
        int min=0,max=0;
        int[] c = null;
        for(int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                continue; // min都比i的元素大了，不需要去比较max
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }
        c = new int[max-min+1];
        for(int i=0; i<arr.length; i++){
            int itemIndex = arr[i] - min;
            c[itemIndex]++;
        }

        int a = 0;
        for(int index = 0; index < c.length; index++) {
            for(int count = 0; count < c[index]; count++){
                arr[a++] = index + min;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,9,5,2,8,6,7,15,10};
        nums = countSort();
        for(int i : nums){
            System.out.printf("%d,", i);
        }

    }
}
