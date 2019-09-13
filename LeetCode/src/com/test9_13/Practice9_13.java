package com.test9_13;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice9_13 {
    public static void main(String[] args) {

    }
}


//矩阵动态规划
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            System.out.println(minWay(arr,0,0,0));
        }
        in.close();
    }

    private static int minWay(int[][] arr, int i, int j, int length) {
        if (i == arr.length - 1 && j == arr[i].length - 1) {
            return length + arr[i][j];
        }
        length += arr[i][j];
        int up = Integer.MAX_VALUE;
        if (i < arr.length - 1) {
            up = minWay(arr,i + 1, j,length);
        }
        int right = Integer.MAX_VALUE;
        if (j < arr[i].length - 1) {
            right = minWay(arr,i,j+1,length);
        }
        return Math.min(up,right);
    }
}

//有序数组去重
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            String[] values = string.trim().split(",");
            Set<String> set = new HashSet<>();
            for (int i = 0; i < values.length; i++) {
                set.add(values[i]);
            }
            System.out.println(set.size());
        }
        in.close();
    }
}

//单链表的倒数第k个节点
class Solution2 {
    static class ListNode {
        String val;
        ListNode next;
        public ListNode(String val) {
            this.val = val;
        }
    }
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] values = string.trim().split(" ");
        solution(values);
        in.close();
    }

    private static void solution(String[] values) {
        //将输入的数组构造为链表
        int k = Integer.parseInt(values[values.length - 1]);
        ListNode head = new ListNode(values[0]);
        ListNode node = head;
        for (int i = 1; i < values.length - 1; i++) {
            node.next = new ListNode(values[i]);
            node = node.next;
        }
        //s指针的起始位置，f在s后面k个
        ListNode s = head;
        ListNode f = head;
        //因为k小于等于链表长度，所以此次循环不会出现空指针
        //找到f指针的起始位置
        for (int i = 0; i < k; i++) {
            f = f.next;
        }
        //f和s同时往后走，当f走到最后一个节点的之后，s在f前面第k个，所有s此时是链表
        //的倒数第k个节点
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        System.out.println(s.val);
    }
}
