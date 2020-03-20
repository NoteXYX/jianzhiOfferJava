//0～n-1中缺失的数字
package com.jianzhi;

public class Main53_2 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = len-1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m)
                i = m + 1;
            else
                j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        Main53_2 m = new Main53_2();
        int[] nums = {0,1,3};
        System.out.println(m.missingNumber(nums));
    }
}
