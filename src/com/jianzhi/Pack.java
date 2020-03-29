package com.jianzhi;

public class Pack {
    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        Pack01 pack01 = new Pack01();
        System.out.println(pack01.knapSack(w, v, 5));
    }
}
class Pack01 {
    public static int knapSack(int[] w, int[] v, int cap) {
        int num = w.length;
        if (num == 0 || cap == 0)
            return 0;
        int[][] dp = new int[num][cap+1];
        for (int i = 0; i <= cap; i++) {
            dp[0][i] = w[0]<=i ? v[0] : 0;  //先初始化放入第一个物品
        }
        for (int i = 1; i < num; i++) {
            for (int j = 0; j <=cap ; j++) {
                dp[i][j] = dp[i-1][j];  //默认为不放当前第i个物品
                if (w[i] <= j)
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
            }
        }
        return dp[num-1][cap];
    }
}
