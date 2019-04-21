package com.leetcode;

public class BinarySearch {

    /**
     * 二分查找
     * @param arr
     * @param keyNumber
     * @return
     */
    public static int binarySearch(int[] arr, int keyNumber){
        int left = 0;
        int right = arr.length -1;
        while (left<=right){
            int mid = (right + left)/2;
            if(arr[mid] == keyNumber){
                return mid;
            }else if(keyNumber > arr[mid]){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种，找出第一个匹配
     * @param arr
     * @param keyNumber
     * @return
     */
    public static int binarySearch2(int[] arr, int keyNumber){
        int left = 0;
        int right = arr.length -1;
        while (left<=right){
            int mid = (right + left)/2;
            if(keyNumber <= arr[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        if(left<arr.length && arr[left] == keyNumber) return left;
        return -1;
    }

    /**
     * 二分查找变种，找出最后一个匹配
     * @param arr
     * @param keyNumber
     * @return
     */
    public static int binarySearch3(int[] arr, int keyNumber){
        int left = 0;
        int right = arr.length - 1;
        while (left<=right){
            int mid = (right + left)/2;
            if(keyNumber >= arr[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if(right>=0 && arr[right] == keyNumber) return right;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,5,5,7};
        System.out.println(binarySearch3(arr,5));
    }
}
