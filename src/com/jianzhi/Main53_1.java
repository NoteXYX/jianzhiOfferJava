//在排序数组中查找数字_1
package com.jianzhi;

public class Main53_1 {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0)
            return 0;
        int count = 0;
        for (int num: nums) {
            if (num == target)
                count++;
            if (num > target)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        Main53_1 m = new Main53_1();
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(m.search(nums, target));
    }
}
