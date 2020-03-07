//数值的整数次方
package com.jianzhi;
public class Main16 {
    public double myPow(double x, int n) {
        double res = 1;
        if (x == 0 || n == 0)
            return res;
        long absN = Math.abs(n);
        res = myCore(x, absN);
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }
    public double myCore(double x, long n) {
        double res = 1;
        if (n == 0)
            return res;
        if (n == 1)
            return x;
        res = myCore(x, n >>> 1);   //无符号右移
        res *= res;
        if ((n & 1) != 0) {
            res *= x;
        }
        return res;
    }
    public static void main(String[] args) {
        Main16 m = new Main16();
        System.out.println(m.myPow(1.0000, -2147483648));
    }
}