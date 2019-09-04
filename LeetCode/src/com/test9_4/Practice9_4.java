package com.test9_4;

import java.util.*;

public class Practice9_4 {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        Solution2 solution2 = new Solution2();
        List<Integer> list = solution2.rightSideView(t1);
        printList(list);

    }
    private static void printList(List<Integer> list) {
        for (Integer o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}


//二叉树的右视图
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution2 {
    //解法一
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                if (n == 0) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return list;
    }

    //解法二
    private Map<Integer,Integer> map = new TreeMap<>();
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        addNode(root,0);
        for (Integer key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }
    private void addNode(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        map.put(depth,node.val);
        addNode(node.left,depth + 1);
        addNode(node.right,depth + 1);
    }
}


//整数二进制表示
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int value = in.nextInt();
            System.out.println(oneCount(value));
        }
        in.close();
    }

    private static int oneCount(int value) {
        int count = 0;
        while (value > 0) {
            if ((value & 1) == 1) {
                count++;
            }
            value >>= 1;
        }
        return count;
    }
}