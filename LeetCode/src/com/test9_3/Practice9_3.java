package com.test9_3;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Practice9_3 {

    public static void main(String[] args) {
        Solution.solution();

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.frequencySort("tree"));
        System.out.println(solution1.frequencySort("cccaaa"));
        System.out.println(solution1.frequencySort("Aabb"));

    }
}


//宝藏
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 || m == 0) {
                System.out.println(0);
            } else {
                ArrayList<Integer> boxes = new ArrayList<>(n);
                ArrayList<Integer> keys = new ArrayList<>(m);
                for (int i = 0; i < n; i++) {
                    boxes.add(in.nextInt());
                }
                for (int i = 0; i < m; i++) {
                    keys.add(in.nextInt());
                }
                System.out.println(maxBoxes(boxes,keys));
            }
        }
        in.close();
    }
    private static int maxBoxes(ArrayList<Integer> boxes, ArrayList<Integer> keys) {
        int jBox = 0;
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i) % 2 == 1) {
                jBox++;
            }
        }
        int oBox = boxes.size() - jBox;
        int jKey = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) % 2 == 1) {
                jKey++;
            }
        }
        int oKey = keys.size() - jKey;
        return Math.min(jBox,oKey) + Math.min(oBox,jKey);
    }
}

//根据字符出现的频率排序（LeetCode）
//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
class Solution1 {
    public String frequencySort(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        Map<Character,Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key,map.get(key) + 1);
            } else {
                map.put(key,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : list) {
            char key = (char) entry.getKey();
            int value = (int) entry.getValue();
            for (int i = 0; i < value; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
