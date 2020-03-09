//之字形打印二叉树
package com.jianzhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main32_3 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int needPrintLine = 1;
        while (stack1.size()!=0 || stack2.size()!=0) {
            List<Integer> tmp = new ArrayList<>();
            if ((needPrintLine & 1) == 1) { //若为奇数行
                while (stack1.size() > 0) {
                    TreeNode node = stack1.pop();
                    tmp.add(node.val);
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }
            }
            else {  //若为偶数行
                while (stack2.size() > 0) {
                    TreeNode node = stack2.pop();
                    tmp.add(node.val);
                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }
            }
            res.add(tmp);
            needPrintLine++;
        }
        return res;
    }
}
