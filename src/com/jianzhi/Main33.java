//二叉搜索树的后序遍历序列
package com.jianzhi;
public class Main33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder==null || postorder.length==0)
            return true;
        int start = 0;
        int end = postorder.length - 1;
        return verifyCore(postorder, start, end);
    }
    public boolean verifyCore(int[] postorder, int start, int end) {
        if (end - start == 0)
            return true;
        int i = start;
        int root = postorder[end];
        for (; i<end; i++) {
            if (postorder[i] > root)
                break;
        }
        int j = i;
        for (; j<end; j++) {
            if (postorder[j] < root)
                return false;
        }
        boolean left = true;
        if (i > start)   // 有左子树
            left = verifyCore(postorder, start, i-1);
        boolean right = true;
        if (i < end)  //有右子树
            right = verifyCore(postorder, i, end-1);
        return left && right;
    }
    public static void main(String[] args) {
        Main33 m = new Main33();
        int[] postOrder = {2,4,6,3,5};
        System.out.println(m.verifyPostorder(postOrder));
    }
}
