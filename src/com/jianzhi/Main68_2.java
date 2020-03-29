//二叉树的最近公共祖先节点
package com.jianzhi;

public class Main68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
            return root;
        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);
        if(leftNode==null)
            return rightNode;
        if(rightNode==null)
            return leftNode;
        return root;
    }
}
