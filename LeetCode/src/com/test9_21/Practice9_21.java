package com.test9_21;

import java.util.Scanner;

public class Practice9_21 {

    public static void main(String[] args) {
        Solution1.solution();

        Solution2.solution();

    }
}


//最小位数和
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int value = in.nextInt();
                getValue(value);
            }
        }
        in.close();
    }
    private static void getValue(int value) {
        if (value < 10) {
            System.out.println(value);
        } else {
            StringBuilder sb = new StringBuilder();
            while (value > 9) {
                sb.append(9);
                value -= 9;
            }
            sb.append(value);
            System.out.println(sb.reverse());
        }
    }
}


//翻倍
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int A = in.nextInt();
                int B = in.nextInt();
                int p = in.nextInt();
                int q = in.nextInt();
                getCount(A, B, p, q);
            }
        }
        in.close();
    }

    private static void getCount(int a, int b, int p, int q) {
        int count = 0;
        while (a < b) {
            if (a + p >= b) {
                a += p;
            } else if (p * q > p) {
                p *= q;
            } else {
                a += p;
            }
            count++;
        }
        System.out.println(count);
    }
}