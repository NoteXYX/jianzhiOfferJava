//股票的最大收益
package com.jianzhi;

public class Main63 {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)
            return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
    public static void main(String[] args) {
        Main63 m = new Main63();
        int[] prices = {5, 8, 1, 2, 2};
        System.out.println(m.maxProfit(prices));
    }
}
