//根据前序和中序遍历重建二叉树
package com.jianzhi;
public class Main4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre==null || pre.length==0) {
            return null;
        }
        TreeNode root = reConstructCore(pre, in, 0, pre.length-1, 0, in.length-1);
        return root;
    }
    public TreeNode reConstructCore(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
        int rootVal = pre[startPre];
        TreeNode root = new TreeNode(rootVal);
        if (startPre == endPre) {
            return root;
        }
        else {
            int rootIn = startIn;
            while (rootIn <= endIn) {   //在中序遍历中寻找根结点
                if (in[rootIn] == rootVal)
                    break;
                rootIn++;
            }
            int leftLength = rootIn - startIn;
            if (leftLength > 0){
                TreeNode leftSubTree = reConstructCore(pre, in, startPre+1, startPre+leftLength, startIn, rootIn-1);
                root.left = leftSubTree;
            }
            if (endPre-startPre > leftLength) {
                TreeNode rightSubTree = reConstructCore(pre, in, startPre + leftLength + 1, endPre, rootIn + 1, endIn);
                root.right = rightSubTree;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        Main4 m = new Main4();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(m.reConstructBinaryTree(pre, in).val);
    }
}
