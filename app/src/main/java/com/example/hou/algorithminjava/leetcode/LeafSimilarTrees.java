package com.example.hou.algorithminjava.leetcode;

public class LeafSimilarTrees {

    public static void main(String []args){

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    public static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {

            return getVal(root1)==getVal(root2);
        }

        public int getVal(TreeNode root){
            if (root==null){
                return 0;
            }
            if (root.left!=null||root.right!=null) {   // 如果有子节点 递归
                return getVal(root.left) + getVal(root.right);
            }
            return root.val;
        }
    }
}
