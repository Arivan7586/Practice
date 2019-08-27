package com.test8_27;

import java.util.Scanner;

public class Practice8_27 {

    public static void main(String[] args) {
        Solution.solution();
    }
}

//迷路的牛牛（牛客网）
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String value = in.next();
            String direction = "N";
            for (int i = 0; i < value.length(); i++) {
                char flag = value.charAt(i);
                if (direction.equals("N")) {
                    if (flag == 'L') {
                        direction = "W";
                    } else {
                        direction = "E";
                    }
                } else if (direction.equals("S")) {
                    if (flag == 'L') {
                        direction = "E";
                    } else {
                        direction = "W";
                    }
                } else if (direction.equals("E")) {
                    if (flag == 'L') {
                        direction = "N";
                    } else {
                        direction = "S";
                    }
                } else {
                    if (flag == 'L') {
                        direction = "S";
                    } else {
                        direction = "N";
                    }
                }
            }
            System.out.println(direction);
        }
        in.close();
    }
}


//回文子串
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length() + 1; j++) {
                if (isTrue(input.substring(i,j))) {
                    num++;
                }
            }
        }
        System.out.println(num);
    }
    private static boolean isTrue(String value) {
        if (value == null) {
            return false;
        }
        if (value.length() == 1) {
            return true;
        }
        int l = 0;
        int r = value.length() - 1;
        while (l <= r) {
            if (value.charAt(l++) != value.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}

//数字序列第n位的值
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num = 0;
        while (n > 0) {
            n -= num;
            num++;
        }
        System.out.println(num - 1);
    }
}