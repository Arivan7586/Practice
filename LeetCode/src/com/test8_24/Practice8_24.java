package com.test8_24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice8_24 {

    public static void main(String[] args) {

//        Solution.solution();

        Solution1.solution();


    }
}

//字符串中找出连续最长的数字串（牛客网）
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String res = "";
            String value = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    value += c;
                } else {
                    if (!value.equals("")) {
                        res = res.length() > value.length() ? res : value;
                        value = "";
                    }
                }
            }
            if (!value.equals("")) {
                res = res.length() > value.length() ? res : value;
                value = "";
            }
            System.out.println(res);
        }
    }
}

//参观（牛客网）
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            //记录桌子的大小
            int[] table = new int[n];
            long maxMoney = 0L;

            for (int i = 0; i < n; i++) {
                table[i] = in.nextInt();
            }
            //记录每批客人的人数和预消费金额
            int[][] consumers = new int[m][2];
            for (int i = 0; i < m; i++) {
                consumers[i][0] = in.nextInt();
                consumers[i][1] = in.nextInt();
            }
            Arrays.sort(table);
            //标记桌子是否被使用
            int[] flag = new int[n];

            //按照客人的消费金额大小排序
            Arrays.sort(consumers, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });

            for (int i = 0; i < m; i++) {
                if (table[n - 1] < consumers[i][0]) {
                    continue;
                }
                int b = consumers[i][0]; //当前批顾客人数
                int c = consumers[i][1]; //当前批顾客消费值

                int index = findIndex(b, table);
                while (index < n && flag[index] == 1) {
                    index++;
                }
                if (index < n) {
                    maxMoney += c;
                    flag[index] = 1;
                }
            }
            System.out.println(maxMoney);
        }
        in.close();
    }

    private static int findIndex(int num, int[] table) {
        int l = 0;
        int r = table.length - 1;
        int index = 0;
        while (l <= r) {
            index = (r + l) >> 1;
            if (num <= table[index]) {
                r = index - 1;
            } else {
                l = index + 1;
            }
        }
        return l;
    }
}

