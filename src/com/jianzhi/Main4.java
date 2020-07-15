//根据前序和中序遍历重建二叉树
package com.jianzhi;
public class Main4 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reBuild(int[] pre, int[] in) {
        if (pre == null || pre.length == 0)
            return null;
        TreeNode root = recur(pre, in, 0, pre.length-1, 0, in.length-1);
        return root;
    }
    public TreeNode recur(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
        int rootVal = pre[startPre];
        TreeNode root = new TreeNode(rootVal);
        if (startPre == endPre)
            return root;
        int rootIn = startIn;
        while (in[rootIn] != rootVal) {
            rootIn += 1;
        }
        int leftLen = rootIn - startIn;
        if (leftLen > 0) {
            TreeNode leftSub = recur(pre, in, startPre+1, startPre+leftLen, startIn, rootIn-1);
            root.left = leftSub;
        }
        if (endPre - startPre > leftLen) {
            TreeNode rightSub = recur(pre, in, startPre+leftLen+1, endPre, rootIn+1, endIn);
            root.right = rightSub;
        }
        return root;
    }
    public static void main(String[] args) {
        Main4 m = new Main4();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(m.reBuild(pre, in).val);
    }
}
