//树的子结构
package com.jianzhi;

public class Main26 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
 }
    public boolean Equals(double a, double b) {
        if (Math.abs(a-b) < 1e-7)
            return true;
        return false;
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if (A!=null && B!=null) {
            if (A.val == B.val)
                res = hasSubTree(A, B);
            if (!res)
                res = isSubStructure(A.left, B);
            if (!res)
                res = isSubStructure(A.right, B);
        }
        return res;
    }
    public boolean hasSubTree(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (!(A.val == B.val))
            return false;
        return hasSubTree(A.left, B.left) && hasSubTree(A.right, B.right);
    }
}
