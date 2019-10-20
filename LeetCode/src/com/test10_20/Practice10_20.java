package com.test10_20;

public class Practice10_20 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cutRope(8));

    }
}


//剪绳子（剑指offer）

//给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
//        每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]
//        可能的最大乘积是多少？例如，当绳子的长度是8时，
//        我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
class Solution {
    public int cutRope(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        } else {
            int[] dp = new int[target + 1];
            for (int i = 0; i <= 3; i++) {
                dp[i] = i;
            }
            int max = 0;
            for (int i = 4; i <= target; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    int value = dp[j] * dp[i - j];
                    max = Math.max(value,max);
                }
                dp[i] = max;
            }
            return max;
        }
    }
}