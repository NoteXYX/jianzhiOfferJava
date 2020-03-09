//包含min函数的栈
package com.jianzhi;

import java.util.Stack;

public class Main30 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        dataStack.push(x);
        if (minStack.size() == 0 || x < minStack.peek())
            minStack.push(x);
        else
            minStack.push(minStack.peek());
    }
    public void pop() {
        if (dataStack.size()>0 && minStack.size()>0) {
            dataStack.pop();
            minStack.pop();
        }

    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
