//斐波那契数列
package com.jianzhi;
public class Main7 {
    public int Fibonacci(int n) {   //递归版
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    public int Fibonacci_2(int n) { //非递归版
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int fnm1 = 1;
        int fnm2 = 1;
        int f = 0;
        for (int i = 3; i <= n; i++) {
            f = fnm1 + fnm2;
            fnm2 = fnm1;
            fnm1 = f;
        }
        return f;
    }
    public static void main(String[] args) {
        Main7 m = new Main7();
        System.out.println(m.Fibonacci_2(6));
    }
}
