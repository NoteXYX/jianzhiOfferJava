//数组中数字出现的次数
package com.jianzhi;

import java.util.ArrayList;

public class Main56_1 {
    public int[] singleNumbers(int[] nums) {
        if (nums==null || nums.length<2)
            return new int[0];
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            first ^= nums[i];
        }
        int n = last1Pos(first);
        ArrayList<Integer> arrN0 = new ArrayList<>();
        ArrayList<Integer> arrN1 = new ArrayList<>();
        for (int num: nums) {
            if (((num >> n) & 1) == 0)
                arrN0.add(num);
            else
                arrN1.add(num);
        }
        int res0 = arrN0.get(0);
        int res1 = arrN1.get(0);
        for (int i = 1; i < arrN0.size(); i++) {
            res0 ^= arrN0.get(i);
        }
        for (int i = 1; i < arrN1.size(); i++) {
            res1 ^= arrN1.get(i);
        }
        return new int[]{res0, res1};
    }
    public int last1Pos(int x) {
        int n = 0;
        while ((x&1) != 1) {
            x >>= 1;
            n++;
        }
        return n;
    }
}
