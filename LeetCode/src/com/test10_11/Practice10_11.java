package com.test10_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Practice10_11 {

    public static void main(String[] args) {
        Solution.solution();

    }
}


//连续数字组合

//给定一组数字（每个数字取值范围位0-100，可重复出现，其中0位万能数字，可以代表
//其他任何数字），判断它们是否是连续数字组合

class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            boolean flag = false;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int value = in.nextInt();
                if (list.contains(value) && value != 0) {
                    flag = true;
                } else {
                    list.add(value);
                }
                if (value == 0) {
                    count++;
                }
            }
            if (flag) {
                System.out.println("NO+" + count);
            } else {
                if (count == list.size()) {
                    System.out.println("YES+" + count);
                } else {
                    Collections.sort(list);
                    boolean res = false;
                    int sum = count;
                    int value = list.get(count);
                    for (int i = count; i < list.size(); ) {
                        if (value == list.get(i)) {
                            value++;
                            i++;
                        } else {
                            if (sum > 0) {
                                sum--;
                                value++;
                            } else {
                                res = true;
                                break;
                            }
                        }
                    }
                    if (res) {
                        System.out.println("NO+" + count);
                    } else {
                        System.out.println("YES+" + count);
                    }
                }
            }
        }
        in.close();
    }
}