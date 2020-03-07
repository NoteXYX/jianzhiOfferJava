//剪绳子
package com.jianzhi;
import java.util.ArrayList;
import java.util.Arrays;

public class Main14 {
    public int cuttingRope(int n) { //动态规划
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        ArrayList<Integer> array = new ArrayList();
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        int max = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                if (array.get(j) * array.get(i-j) > max) {
                    max = array.get(j) * array.get(i-j);
                }
            }
            array.add(max);
        }
        return max;
    }
    public int tanxin(int n) {  //贪心
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int numOf3 = n / 3;
        if (n - numOf3 * 3 == 1)
            numOf3--;
        int numOf2 = (n - numOf3 * 3) / 2;
        int res = (int)(Math.pow(3, numOf3) * Math.pow(2, numOf2));
        return res ;
    }
    public int remainder(int x, int a, int p){
        int rem = 1;
        for (int i = 0; i < a; i++) {
            rem = (rem * x) % p;
        }
        return rem;
    }
    public static void main(String[] args) {
        Main14 m = new Main14();
        System.out.println(m.tanxin(120));
    }
}
