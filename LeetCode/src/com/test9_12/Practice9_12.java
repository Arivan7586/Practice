package com.test9_12;

import java.util.*;

public class Practice9_12 {

    public static void main(String[] args) {
        Solution.solution();

        Solution1.solution();
    }
}


//发工资
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0; i < n; i++) {
                int key = in.nextInt();
                int value = in.nextInt();
                map.put(key,value);
            }
            System.out.println(maxCount(map,m));
        }
        in.close();
    }

    private static int sumOfMap(Map<Integer, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int key : map.keySet()) {
            sum += key * map.get(key);
        }
        return sum;
    }

    private static int maxCount(Map<Integer, Integer> map, int m) {
        int maxCount = 0;
        int money = m;
        while (sumOfMap(map) >= money) {
            int realKey = -1;
            boolean flag = false;
            boolean v = false;
            for (int key : map.keySet()) {
                if (key >= money && map.get(key) >= 1) {
                    realKey = key;
                    if (v) {
                        map.put(key,map.get(key) - 1);
                        money -= key;
                    } else {
                        flag = true;
                    }
                    if (money <= 0) {
                        maxCount++;
                        money = m;
                        break;
                    }
                } else if (key < money && realKey == -1 && map.get(key) >= 1) {
                    map.put(key,map.get(key) - 1);
                    money -= key;
                    v = true;
                    if (money <= 0) {
                        maxCount++;
                        money = m;
                        break;
                    }
                    realKey = key;
                }
            }
            if (flag) {
                map.put(realKey,map.get(realKey) - 1);
                maxCount++;
                money = m;
            }
        }
        return maxCount;
    }
}


//根据二叉树的中序、后序遍历求出前序遍历
class Solution1 {
    //二叉树
    static class TreeNode {
        Character val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            char[] mid = in.next().toCharArray();
            char[] back = in.next().toCharArray();
            System.out.println(getString(mid, back));
        }
        in.close();
    }

    /**
     * 根据中序遍历字符数组和后续遍历字符数组，构建二叉树，并返回前序遍历拼接的字符串
     * @param mid 中序遍历字符数组
     * @param back 后序遍历字符数组
     * @return 返回拼接后的字符串
     */
    private static String getString(char[] mid, char[] back) {
        //构建二叉树
        TreeNode root = getTree(mid, back, back.length - 1, 0, mid.length - 1);
        //前序遍历二叉树，并将前序遍历结果拼接成字符串
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sb.toString();
    }

    /**
     * 构建二叉树
     * @param mid 中序遍历字符数组
     * @param back 后续遍历字符数组
     * @param br 后续遍历字符数组的最后一个元素的下标
     * @param ml 中续遍历字符数组的第一个元素的下标
     * @param mr 中续遍历字符数组的最后一个元素的下标
     * @return 返回构建好的二叉树
     */
    private static TreeNode getTree(char[] mid, char[] back, int br, int ml, int mr) {
        if (ml > mr) {
            return null;
        }
        char currentVal = back[br];
        //构建根节点
        TreeNode current = new TreeNode(currentVal);
        int inIndex = 0;
        for (int i = ml; i <= mr; i++) {
            if (mid[i] == currentVal) {
                inIndex = i;
            }
        }
        //构建左右子树
        TreeNode left = getTree(mid, back, br - (mr - inIndex) - 1, ml, inIndex - 1);
        TreeNode right = getTree(mid, back, br - 1, inIndex + 1, mr);
        current.left = left;
        current.right = right;
        return current;
    }
}