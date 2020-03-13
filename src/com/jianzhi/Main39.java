//数组中出现次数超过一半的数字
package com.jianzhi;

public class Main39 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                res = nums[i];
                times = 1;
            }
            else if (nums[i] == res)
                times++;
            else
                times--;
        }
        return res;
    }
    public static void main(String[] args) {
        Main39 m = new Main39();
        int[] a = {1,2,1,2,2};
        System.out.println(m.majorityElement(a));
    }
}
