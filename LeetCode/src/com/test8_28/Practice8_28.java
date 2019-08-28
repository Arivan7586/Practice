package com.test8_28;

import java.util.*;

public class Practice8_28 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(1);
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;


        Solution1 solution1 = new Solution1();
        System.out.println(solution1.FindPath(t1,22));
        System.out.println(solution1.FindPath(t1,15));
        System.out.println(solution1.FindPath(n1,15));

    }
}


//复杂链表的复制（剑指offer）
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return pHead;
        }
        //复制链表
        RandomListNode conNode = pHead;
        while (conNode != null) {
            RandomListNode newNode = new RandomListNode(conNode.label);
            RandomListNode nextNode = conNode.next;
            conNode.next = newNode;
            newNode.next = nextNode;
            conNode = nextNode;
        }

        RandomListNode head = pHead;
        while (head != null) {
            head.next.random = head.random == null ? null : head.random.next;
            head = head.next.next;
        }

        head = pHead;
        RandomListNode resNode = pHead.next;
        while (head != null) {
            RandomListNode node = head.next;
            head.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            head = head.next;
        }
        return resNode;
    }
}

//二叉树和为某一值的路径
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
class Solution1 {
    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        add(root,0,list);
        Iterator<ArrayList<Integer>> iterator = lists.iterator();
        while (iterator.hasNext()) {
            ArrayList<Integer> flag = iterator.next();
            if (flag.get(flag.size() - 1) != target) {
                iterator.remove();
            } else {
                flag.remove(flag.size() - 1);
            }
        }
        Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return lists;
    }
    private void add(TreeNode node, int sum, ArrayList<Integer> list) {
        list.add(node.val);
        sum += node.val;
        if (node.left == null && node.right == null) {
            lists.add(list);
            list.add(sum);
            return;
        }
        int value = sum;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            leftList.add(list.get(i));
            rightList.add(list.get(i));
        }
        if (node.left != null) {
            add(node.left,value,leftList);
        }
        if (node.right != null) {
            add(node.right,value,rightList);
        }
    }
}