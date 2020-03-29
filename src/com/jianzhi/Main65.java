//不用加减乘除做加法
package com.jianzhi;

public class Main65 {
    public int add(int a, int b) {
        int sum = 0;
        int carry = 0;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (carry != 0);
        return sum;
    }

    public static void main(String[] args) {
        Main65 m = new Main65();
        System.out.println(m.add(50,51));
    }
}
