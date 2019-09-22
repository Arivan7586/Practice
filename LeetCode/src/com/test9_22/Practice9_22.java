package com.test9_22;

import java.util.Scanner;

public class Practice9_22 {

    public static void main(String[] args) {
        Solution1.solution();

        Solution2.solution();

    }
}


//逆序对距离之和
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(getLength(arr));
        }
        in.close();
    }
    private static int getLength(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    sum += j - i;
                }
            }
        }
        return sum;
    }
}


//完美的序列
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[j] = in.nextInt();
                }
                solution(arr);
            }
        }
        in.close();
    }

    private static void solution(int[] arr) {
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= sum) {
                    count++;
                    sum += arr[j];
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }
}