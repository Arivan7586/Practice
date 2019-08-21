package com.test8_21;

import java.util.Random;
import java.util.Stack;

public class Practice8_21 {

    public static void main(String[] args) {

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(200);
        }
        print(arr);

//        Sort.bubbleSort(arr);
//        Sort.chooseSort(arr);
//        Sort.insertSort(arr);
//        Sort.shellSort(arr);
//        Sort.mergeSort(arr);
//        Sort.quickSort1(arr);
//        Sort.quickSort2(arr);
        Sort.heapSort(arr);

        print(arr);
    }
    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

//二叉树的直径（LeetCode）
class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        max = Math.max(left + right, max);
        return Math.max(left,right) + 1;
    }
}

class Sort {
    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    
    //选择排序
    public static void chooseSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr,i,j);
                }
            }
        }
    }

    //普通插入排序
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    //shell排序
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = n / 2; i >= 1 ; i /= 2) {
            for (int j = i; j < n; j++) {
                int value = arr[j];
                int k = j - i;
                while (k >= 0) {
                    if (arr[k] > value) {
                        arr[k + i] = arr[k];
                        k -= i;
                    } else {
                        break;
                    }
                }
                arr[k + i] = value;
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        partation(arr,0,arr.length-1);
    }
    private static void partation(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        partation(arr,l,mid);
        partation(arr,mid+1,r);
        if (arr[mid] > arr[mid+1]) {
            mergeInternal(arr,l,mid,r);
        }
    }
    private static void mergeInternal(int[] arr, int l, int mid, int r) {
        int[] array = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                array[k++] = arr[i++];
            } else {
                array[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            array[k++] = arr[start++];
        }
        for (int m = 0; m < array.length; m++) {
            arr[l + m] = array[m];
        }
    }

    //递归快速排序
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        internal(arr,0,arr.length - 1);
    }
    private static void internal(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = findIndex3(arr,l,r);
        internal(arr,l,index - 1);
        internal(arr,index + 1, r);
    }
    private static int findIndex1(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = l;
        while (i <= r) {
            if (arr[i] < value) {
                swap(arr,i++,++j);
            } else {
                i++;
            }
        }
        swap(arr,l,j);
        return j;
    }
    private static int findIndex2(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i] < value) {
                i++;
            }
            while (j >= i && arr[j] > value) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr,i++,j--);
        }
        swap(arr,l,j);
        return j;
    }
    private static int findIndex3(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = l;
        int k = r + 1;
        while (i < k) {
            if (arr[i] < value) {
                swap(arr,i++,++j);
            } else if (arr[i] > value) {
                swap(arr,i,--k);
            } else {
                i++;
            }
        }
        swap(arr,l,j);
        return j;
    }

    //非递归快速排序
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int l = 0;
        int r = arr.length - 1;
        int index = findIndex3(arr,l,r);
        if (index > l + 1) {
            stack.push(l);
            stack.push(index - 1);
        }
        if (index < r - 1) {
            stack.push(index + 1);
            stack.push(r);
        }
        while (!stack.isEmpty()) {
            r = stack.pop();
            l = stack.pop();
            index = findIndex3(arr,l,r);
            if (index > l + 1) {
                stack.push(l);
                stack.push(index - 1);
            }
            if (index < r - 1) {
                stack.push(index + 1);
                stack.push(r);
            }
        }
    }

    //堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        //将数组变为大顶堆
        for (int i = (n - 1) / 2; i >= 0; i--) {
            siftDown(arr,i,n);
        }
        //排序
        for (int i = n - 1; i >= 0; i--) {
            swap(arr,0,i);
            siftDown(arr,0,i);
        }
    }
    private static void siftDown(int[] arr, int index, int n) {
        while (index * 2 + 1 < n) {
            int i = 2 * index + 1;
            if (i + 1 < n) {
                i = arr[i+1] > arr[i] ? i + 1 : i;
            }
            if (arr[i] < arr[index]) {
                return;
            }
            swap(arr,i,index);
            index = i;
        }
    }
}