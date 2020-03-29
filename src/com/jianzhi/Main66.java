//构建乘积数组
package com.jianzhi;

import java.util.Arrays;

public class Main66 {
    public int[] constructArr(int[] a) {
        if (a==null || a.length==0)
            return new int[0];
        int[] res = new int[a.length];
        int left = a[0];
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i-1] * left;
            left = a[i];
        }
        int right = 1;
        for (int i = a.length-1; i >= 0; i--) {
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Main66 m = new Main66();
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(m.constructArr(a)));
    }
}
