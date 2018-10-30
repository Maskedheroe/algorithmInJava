package com.example.hou.algorithminjava.practice;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Note
 * Given binary tree {1,#,2,3},
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * return [1,2,3].
 *
 * Example
 * Challenge
 * Can you do it without recursion?
 *
 * */

public class TreeTraversal {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     *
     *  public List<Integer> preorderTraversal(TreeNode root) {
     *         List<Integer> result = new ArrayList<Integer>();
     *         if (root != null) {
     *             // Divide
     *             List<Integer> left = preorderTraversal(root.left);
     *             List<Integer> right = preorderTraversal(root.right);
     *             // Merge
     *             result.add(root.val);
     *             result.addAll(left);
     *             result.addAll(right);
     *         }
     *
     *         return result;
     *     }
     *
     *     时间复杂度  O(n)O(n)O(n)
     */

    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    private static List<Integer> traversal(TreeNode root){
        //递归做法
        List<Integer> result = new ArrayList<Integer>();
        if (root != null){

            //递归左子树
            List<Integer> left = traversal(root.left);
            //递归右子树
            List<Integer> right = traversal(root.right);

            //合并
            result.add(root.val);
            result.addAll(left);
            result.addAll(right);
        }
        return result;

    }

    /**
     *
     * 栈的使用
     * 时间复杂度 O(n)O(n)O(n)
     *
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;                   //终止条件 root为空  所有元素均处理完毕

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);                                      //遍历节点 存入栈中(FILO)
        while (!s.empty()) {                               //当栈不为空时(递归条件)
            TreeNode node = s.pop();
            result.add(node.val);
            if (node.right != null) s.push(node.right);   //先左后右  所以先存右后左 以便遍历时先左后右
            if (node.left != null) s.push(node.left);
        }

        return result;
    }

}
