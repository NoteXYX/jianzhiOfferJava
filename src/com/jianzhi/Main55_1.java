//二叉树的深度
package com.jianzhi;

public class Main55_1 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int maxDepth = 0;
    int curDepth = 1;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        maxCore(root);
        return maxDepth;
    }
    public void maxCore(TreeNode root) {
        if (root.left != null) {
            curDepth++;
            maxCore(root.left);
        }
        if (root.right != null) {
            curDepth++;
            maxCore(root.right);
        }
        if (curDepth > maxDepth) {
            maxDepth = curDepth;
        }
        curDepth--;
    }
    public int maxDepthRecur(TreeNode root) {   //递归版
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Main55_1 m = new Main55_1();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        System.out.println(m.maxDepth(node));
    }
}
