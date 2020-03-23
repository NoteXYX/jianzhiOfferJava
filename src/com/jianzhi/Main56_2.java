//数组中数字出现的次数 II
package com.jianzhi;
import java.util.Arrays;

public class Main56_2 {
    public int singleNumber(int[] nums) {
        int curSum = 0;
        int[] res = new int [32];
        for (int i = 0; i < 32; i++) {
            curSum = sumOfN(nums, i);
            if (curSum % 3 == 0)
                res[i] = 0;
            else
                res[i] = 1;
        }
        int reslut = 0;
        for (int i = 0; i < 32; i++) {
            reslut += res[i] * (1<<i);
        }
        return reslut;
    }
    public int sumOfN(int[] nums, int n) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int sum = 0;
        for (int num: copy) {
            sum += (num>>n) & 1;
        }
        return sum;
    }
}
