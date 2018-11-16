package com.example.hou.algorithminjava.interview

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {  //注意判空顺序  首先是相同判空  (它影响递归出栈、和为null顺序) 所以要首先判断
            return true
        }

        if (p == null || q == null) {
            return false
        }

        return p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)

    }
}