//二叉搜索树最近公共祖先
package com.jianzhi;

public class Main68_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (p == q)
            return p;
        TreeNode curNode = root;
        while (curNode != null) {
            if (p.val < curNode.val && q.val < curNode.val)
                curNode = curNode.left;
            else if (p.val > curNode.val && q.val > curNode.val)
                    curNode = curNode.right;
            else
                break;
        }
        return curNode;
    }
}
