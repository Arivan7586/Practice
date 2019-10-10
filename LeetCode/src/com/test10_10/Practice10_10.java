package com.test10_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice10_10 {

    public static void main(String[] args) {
        Solution.solution();

        Solution1.solution();
        
    }
}


//某网站的注册功能，要求输用户名、密码和手机号，验证规则如下：
//1、用户名不能重复，系统中当前存在的用户名有：zhangsan、lisi
//2、密码长度必须在8-16位之间，并且由数字和字母组成
//3、手机号的长度必须为11为，并且必须以1开头
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        while (in.hasNext()) {
            String name = in.next();
            String password = in.next();
            String phone = in.next();

            if (checkName(name, list)) {
                if (checkPassword(password)) {
                    if (checkPhone(phone)) {
                        list.add(name);
                        System.out.println("注册成功");
                    } else {
                        System.out.println("请输入正确的手机号码");
                    }
                } else {
                    System.out.println("密码格式错误");
                }
            } else {
                System.out.println("该用户名已存在");
            }
        }
        in.close();
    }

    //验证用户名
    private static boolean checkName(String name, List<String> list) {
        if (name == null || name.equals("")) {
            return false;
        }
        if (list.contains(name)) {
            return false;
        }
//        list.add(name);
        return true;
    }

    //验证密码
    private static boolean checkPassword(String password) {
        if (password == null || password.length() < 8
                || password.length() > 16) {
            return false;
        }
        password = password.toLowerCase();
        for (int i = 0; i < password.length(); i++) {
            if ((password.charAt(i) < 'a' || password.charAt(i) > 'z')
                    && (password.charAt(i) < '0' || password.charAt(i) > '9')) {
                return false;
            }
        }
        return true;
    }

    //验证电话号码
    private static boolean checkPhone(String phone) {
        if (phone == null || phone.length() != 11 || !phone.startsWith("1")) {
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < '0' && phone.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}



//输入一个整数n，求用n分解的整数（相加为n），获得最大的乘积

class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(getValue(n));
        }
        in.close();
    }

    private static int getValue(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int max = Math.max(j * (i - j),j * dp[i - j]);
                dp[i] = Math.max(dp[i],max);
            }
        }
        return dp[n];
    }
}