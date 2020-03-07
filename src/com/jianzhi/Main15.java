//二进制中1的个数
package com.jianzhi;
public class Main15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n-1;
        }
        return count;
    }
    public static void main(String[] args) {
        Main15 m = new Main15();
        System.out.println(m.hammingWeight(7));
    }
}