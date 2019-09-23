package com.test9_23;

import java.util.*;

public class Practice9_23 {

    public static void main(String[] args) {

        Solution.solution();
    }
}


//统计热门签到城市
//输入为用户ID及用户签到的城市名称
//        输出
//        签到用户最多的前3个目的地及签到用户数
//        -       同一个用户多次签到同一个城市，只记一次
//        -       签到用户数相同的城市，优先展示拼音顺序靠前的城市名
//        样例输入
//        34839946-beijing 34839946-shanghai 42342124-hongkong 42342124-guilin
//        42342124-guilin 12312344-shanghai 12312344-shanghai 22341234-nanjing
//        样例输出
//        shanghai 2
//        beijing 1
//        guilin 1

class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        //用于存放已经输入的城市
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String values[] = in.nextLine().trim().split(" ");
        for (int i = 0; i < values.length; i++) {
            if (!list.contains(values[i])) {
                list.add(values[i]);
                String key = values[i].trim().split("-")[1];
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(map.entrySet());

        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() - o1.getValue() > 0) {
                    return 1;
                } else if (o2.getValue() - o1.getValue() < 0) {
                    return -1;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        for (int j = 0; j < list1.size() && j < 3; j++) {
            System.out.println(list1.get(j).getKey() + " " + list1.get(j).getValue());
        }
        in.close();
    }
}