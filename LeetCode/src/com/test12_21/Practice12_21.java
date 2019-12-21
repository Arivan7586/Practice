package com.test12_21;

public class Practice12_21 {

    public static void main(String[] args) {

        int[] arr1 = new int[]{33,22,48,4,39,36,41,47,15,45};
        int[] arr2 = new int[]{22,33,48,4};

        int[] arr = new Solution().relativeSortArray(arr1,arr2);
        System.out.println();

    }
}

/**
 * 数组的相对顺序（LeetCode 1122）
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length <= 0 || arr2.length <= 0) {
            return arr1;
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = index; j < arr1.length && index < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    swap(arr1,index++,j);
                }
            }
        }
        if (arr1.length > arr2.length) {

        }
        sort(arr1,index);
        return arr1;
    }

    //交换元素位置
    private void swap(int[] arr, int i, int j) {
        if (i == j || arr[i] == arr[j]) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //按照升序排序
    private void sort(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= index) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }
}