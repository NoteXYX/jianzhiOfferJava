//二叉搜索树的第k大节点
package com.jianzhi;

public class Main54 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int count = 0;
    int result = -1;
    public int kthLargest(TreeNode root, int k) {
        if (root==null || k<=0)
            return 0;
        recurCore(root, k);
        return result;
    }
    public void recurCore(TreeNode root, int k) {
        if (root==null)
            return;
        recurCore(root.right, k);
        count++;
        if (count == k)
            result = root.val;
        recurCore(root.left, k);
    }
}
