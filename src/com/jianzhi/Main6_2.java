//两个队列实现栈
package com.jianzhi;
import java.util.Queue;
import java.util.LinkedList;
public class Main6_2 {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    public void push(int node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(node);
        }
        else {
            if (!queue1.isEmpty())
                queue1.offer(node);
            else
                queue2.offer(node);
        }
    }
    public int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        else {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
    public static void main(String[] args) {
        Main6_2 m = new Main6_2();
        m.push(1);
        m.push(2);
        m.push(3);
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
    }
}
