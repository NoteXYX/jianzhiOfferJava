//栈的压入弹出序列
package com.jianzhi;

import java.util.Stack;

public class Main31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length==0 && popped.length==0)
            return true;
        boolean res = false;
        if (pushed.length>0 && popped.length>0) {
            int pushIndex = 0;
            int popIndex = 0;
            Stack<Integer> stack = new Stack<>();
            while (popIndex<popped.length) {
                while (stack.empty() || stack.peek()!=popped[popIndex]) {
                    if (pushIndex >= pushed.length)
                        break;
                    stack.push(pushed[pushIndex]);
                    pushIndex++;
                }
                if (stack.peek() != popped[popIndex])
                    break;
                stack.pop();
                popIndex++;
            }
            if (stack.empty() && popIndex==popped.length)
                res = true;
        }
        return res;
    }
    public static void main(String[] args) {
        Main31 m =new Main31();
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        System.out.println(m.validateStackSequences(a, b));
    }
}