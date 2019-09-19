package com.test9_19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice9_19 {

    public static void main(String[] args) {
        Solution.solution();

    }
}

//字母组合(LeetCode)
class Solution {
    private static final String[] STRINGS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            System.out.println(solution(string));
        }
        in.close();
    }
    private static List<String> solution(String values) {
        List<String> list = new ArrayList<>();
        if (values == null) {
            return list;
        }
        String str = "";
        run(values,0,str,list);
        return list;
    }
    private static void run(String num, int i, String str, List<String> list) {
        if (i >= num.length()) {
            if (str.length() > 0) {
                list.add(str);
            }
            return;
        }
        int index = num.charAt(i) - '0';
        String value = STRINGS[index];
        char[] chars = value.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            String string = str + chars[j];
            run(num,i+1,string,list);
        }
    }
}
