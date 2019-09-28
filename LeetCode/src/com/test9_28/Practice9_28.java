package com.test9_28;

import java.util.*;

public class Practice9_28 {

    public static void main(String[] args) {

        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(arr));

    }
}

//字母异位词分组
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，
// 但排列不同的字符串。
//
//        示例:
//
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = getString(strs[i]);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        for (String key : map.keySet()) {
            lists.add(map.get(key));
        }
        return lists;
    }

    private String getString(String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}

