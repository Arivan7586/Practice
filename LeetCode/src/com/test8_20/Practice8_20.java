package com.test8_20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Practice8_20 {

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        int[] arr = {4,2,3};
        System.out.println(solution1.largestSumAfterKNegations(arr,1));

        Solution2 solution2 = new Solution2();
        int[][] aa = {{1,3},{2,3}};
        System.out.println(solution2.findJudge(3,aa));

        int[][] bb = {{1,3},{2,3},{3,1}};
        System.out.println(solution2.findJudge(3,bb));

        int[][] cc = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(solution2.findJudge(4,cc));

    }
}


//二叉树的堂兄弟节点（LeetCode）
class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int xpar, ypar, xdep, ydep;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        getDepth(root.left,x,y,root.val,1);
        getDepth(root.right,x,y,root.val,1);
        return (xpar != ypar) && (xdep == ydep);
    }
    private void getDepth(TreeNode node, int x, int y, int par, int depth) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xdep = depth;
            xpar = par;
        } else if (node.val == y) {
            ydep = depth;
            ypar = par;
        } else {
            getDepth(node.left,x,y,node.val,depth+1);
            getDepth(node.right,x,y,node.val,depth+1);
        }
    }
}

//K次取反后最大化的数组和
class Solution1 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        if (A[0] >= 0 && K%2 == 0) {
            return sum(A);
        }
        for (int i = 0; i < A.length && K > 0; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];
                K--;
            } else if (A[i] == 0) {
                break;
            } else {
                if (K % 2 == 0) {
                    break;
                }
                if (i-1 >= 0 && Math.abs(A[i-1]) < A[i]) {
                    A[i-1] = -A[i-1];
                } else {
                    A[i] = -A[i];
                }
                break;
            }
        }
        return sum(A);
    }
    private int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

//找到小镇的法官
class Solution2 {
    public int findJudge(int N, int[][] trust) {
        if (trust == null || trust.length == 0) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] arr : trust) {
            int key = arr[1];
            if (!map.containsKey(key)) {
                map.put(key,1);
            } else {
                map.put(key,map.get(key) + 1);
            }
        }
        int max = 0;
        int per = 0;
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (map.get(key) >= max) {
                per = key;
                max = map.get(key);
            }
        }
        if (max != N - 1) {
            return -1;
        }
        for (int[] arr : trust) {
            if (arr[0] == per) {
                return -1;
            }
        }
        return per;
    }
}