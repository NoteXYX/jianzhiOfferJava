//求1+2+…+n
package com.jianzhi;

public class Main64 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumNums(n-1)) > 0);
        return sum;
    }
    public static void main(String[] args) {
        Main64 m = new Main64();
        System.out.println(m.sumNums(5));
    }
}
