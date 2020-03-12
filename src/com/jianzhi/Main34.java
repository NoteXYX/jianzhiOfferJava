//二叉树中和为某一值的路径
package com.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class Main34 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (root==null)
            return res;
        curPathSum(root, sum, res, tmp);
        return res;
    }
    public void curPathSum(TreeNode root, int remain, List<List<Integer>> res, List<Integer> tmp) {
        tmp.add(root.val);
        remain -= root.val;
        if (root.left==null && root.right==null && remain==0) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(tmp);
            res.add(copy);
        }
        if (root.left != null)
            curPathSum(root.left, remain, res, tmp);
        if (root.right != null)
            curPathSum(root.right, remain, res, tmp);
        tmp.remove(tmp.size()-1);   //到叶子
    }
    public static void main(String[] args) {
        Main34 m = new Main34();
        TreeNode root11 = new TreeNode(5);
        TreeNode root21 = new TreeNode(4);
        TreeNode root22 = new TreeNode(8);
        TreeNode root31 = new TreeNode(11);
        TreeNode root32 = new TreeNode(13);
        TreeNode root33 = new TreeNode(4);
        TreeNode root41 = new TreeNode(7);
        TreeNode root42 = new TreeNode(2);
        TreeNode root43 = new TreeNode(5);
        TreeNode root44 = new TreeNode(1);
        root11.left = root21;
        root11.right = root22;
        root21.left = root31;
        root22.left = root32;
        root22.right = root33;
        root31.left = root41;
        root31.right = root42;
        root33.left = root43;
        root33.right = root44;
//        TreeNode root11 = null;
        System.out.println(m.pathSum(root11, 22));

    }
}
