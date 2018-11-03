class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private boolean isBalance(TreeNode root){
        if(root == null)
            return true;
        int left_height = height(root.left);
        int right_height = height(root.right);
        if(Math.abs(left_height - right_height) > 1)
            return false;
        else
            return isBalance(root.left) && isBalance(root.right);
    }


    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        return 1 + (left_height > right_height ? left_height : right_height);
    }
}