//礼物的最大价值
package com.jianzhi;

public class Main47 {
    public int maxValue(int[][] grid) {    //dp[j] = max(dp[i-1][j], dp[i][j-1]) + grid[j]
        if (grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] maxVal = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxVal[j];
                if (j > 0)
                    left = maxVal[j-1];
                maxVal[j] = Math.max(up, left) + grid[i][j];
            }
        }
        return maxVal[cols-1];
    }
    public int maxValue_2(int[][] grid) {   //原地修改
        int row = grid.length, col = grid[0].length;
        for (int i = 1; i < row; ++i)
            grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < col; ++j)
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < row; ++i)
            for (int j = 1; j < col; ++j)
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
        return grid[row - 1][col - 1];
    }
}
