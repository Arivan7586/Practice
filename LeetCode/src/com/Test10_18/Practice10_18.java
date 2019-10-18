package com.Test10_18;

import java.util.Scanner;

public class Practice10_18 {

    public static void main(String[] args) {


    }
}


//上楼梯
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            System.out.println(run(N));
        }
        in.close();
    }
    private static int run(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int a = 1;
            int b = 2;
            int res = 0;
            for (int i = 2; i < n; i++) {
                res = a + b;
                a = b;
                b = res;
            }
            return res;
        }
    }
}