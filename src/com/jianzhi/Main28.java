//对称二叉树
package com.jianzhi;

public class Main28 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricCore(root, root);
    }
    public boolean isSymmetricCore(TreeNode aTree, TreeNode bTree) {
        if (aTree==null && bTree==null)
            return true;
        if (aTree==null || bTree==null)
            return false;
        if (aTree.val != bTree.val)
            return false;
        return isSymmetricCore(aTree.left, bTree.right) &&
               isSymmetricCore(aTree.right, bTree.left);
    }
}
