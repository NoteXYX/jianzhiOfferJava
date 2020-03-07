//机器人的运动范围
package com.jianzhi;
public class Main13 {
    public int movingCount(int rows, int cols, int threshold) {
        int[][] visited = new int[rows][cols];
        return countCore(threshold, rows, cols, 0, 0, visited);
    }
    public int countCore(int threshold, int rows, int cols, int row, int col, int[][] visited) {
        int count = 0;
        if (row>=0 && row<rows && col>=0 && col<cols && visited[row][col]==0 && weiSum(row,col)<=threshold) {
            visited[row][col] = 1;
            count = 1 + countCore(threshold, rows, cols, row-1, col, visited)
                      + countCore(threshold, rows, cols, row+1, col, visited)
                      + countCore(threshold, rows, cols, row, col-1, visited)
                      + countCore(threshold, rows, cols, row, col+1, visited);
        }
        return count;
    }
    public int weiSum(int x, int y) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        while (y > 0) {
            sum += y % 10;
            y = y / 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Main13 m = new Main13();
        System.out.println(m.movingCount(3, 3, 3));
    }
}
