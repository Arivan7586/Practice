package com.test10_5;

import javax.xml.transform.SourceLocator;

public class Practice10_5 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon"));
//        System.out.println("123".indexOf(4));

    }

}


//气球的最大数量（LeetCode）

//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//
//        字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
//
//        示例 1：
//
//        输入：text = "nlaebolko"
//        输出：1
class Solution {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.equals("")) {
            return 0;
        }
        int count = 0;
        char[] words = {'b','a','l','l','o','o','n'};
        int i = 0;
        while (text.length() > 0) {
            if (text.indexOf(words[i]) < 0) {
                break;
            }
            String value = String.valueOf(words[i]);
            text = text.replaceFirst(value,"");
            if (i == 6) {
                count++;
                i = 0;
            }
            i++;
        }
        return count;
    }
}