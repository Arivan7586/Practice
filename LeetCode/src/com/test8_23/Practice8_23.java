package com.test8_23;

import java.util.Arrays;
import java.util.Scanner;

public class Practice8_23 {
    public static void main(String[] args) {

        Solution.solution();

    }
}


//渡河（完美世界笔试）
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int limit = in.nextInt();
        String[] weight = input.trim().split(" ");
        Arrays.sort(weight);
        int i = 0;
        int j = weight.length - 1;
        int maxNum = 0;
        if (Integer.parseInt(weight[i]) >= limit) {
            maxNum = weight.length;
        } else {
            while (i <= j) {
                int l = Integer.parseInt(weight[i]);
                int r = Integer.parseInt(weight[j]);
                if (r >= limit || (l + r) > limit) {
                    j--;
                } else if (l + r <= limit) {
                    i++;
                    j--;
                }
                if (l >= limit) {
                    i++;
                }
                maxNum++;
            }
        }
        System.out.println(maxNum);
        in.close();
    }
}

//海报游戏
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value = in.next();
            int n = value.length() + 1;
            System.out.println(25 * n + 1);
        }
        in.close();
    }
}
