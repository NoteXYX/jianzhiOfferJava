//用两个栈实现队列
package com.jianzhi;
import java.util.Stack;
public class Main6_1 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        else {
            return stack2.pop();
        }
    }
    public static void main(String[] args) {
        Main6_1 m = new Main6_1();
        m.push(1);
        m.push(2);
        m.push(3);
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
    }
}
