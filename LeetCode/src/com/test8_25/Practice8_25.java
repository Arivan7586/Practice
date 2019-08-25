package com.test8_25;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice8_25 {

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        String str = solution.gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"
//                ,"NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM");
//
//        String string = solution.gcdOfStrings("ABCABC","ABC");
//        System.out.println(str);
//        System.out.println(string);

//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.isIsomorphic("egg","add"));
//        System.out.println(solution1.isIsomorphic("foo","bar"));
//        System.out.println(solution1.isIsomorphic("paper","title"));
//        System.out.println(solution1.isIsomorphic("aba","baa"));

        Solution2.solution();


    }

}

//字符串的最大公因子
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }
        String value = "";
        String res = "";
        for (int i = 0; i < str1.length() && value.length() <= str2.length(); i++) {
            if (str1.replaceAll(value,"").equals("") &&
            str2.replaceAll(value,"").equals("")) {
                res = value;
            }
            value += str1.charAt(i);
        }
        return res;
    }
}

//同构字符串
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Character> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (!map.get(sChar).equals(tChar)) {
                    return false;
                }
            } else {
                if (map.containsValue(tChar)) {
                    return false;
                }
                map.put(sChar,tChar);
            }
        }
        return true;
    }
}

//被三整除（牛客网）
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int l = in.nextInt();
            int r = in.nextInt();
            String value = "";
            String flag = "";
            int num = 0;
            for (int i = 1; i <= l; i++) {
                flag += i;
            }
            for (int i = l; i <= r + 1; i++) {
                boolean f = true;
                if (flag.equals("")) {
                    flag += i;
                    f = false;
                }
                if (Integer.parseInt(flag) % 3 == 0) {
                    num++;
                    flag = "";
                } else {
                    if (f) {
                        flag += i;
                    }
                }
            }
            System.out.println(num);
        }
        in.close();
    }
}