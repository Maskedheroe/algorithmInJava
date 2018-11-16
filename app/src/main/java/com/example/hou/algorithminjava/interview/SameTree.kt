package com.example.hou.algorithminjava.interview

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }

        if (p == null || q == null) {
            return false
        }

        return p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)

    }
}