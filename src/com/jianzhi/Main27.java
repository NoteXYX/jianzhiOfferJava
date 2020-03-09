//二叉树的镜像
package com.jianzhi;
public class Main27 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
