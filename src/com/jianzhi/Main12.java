//矩阵中的路径
package com.jianzhi;
public class Main12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] visited = new int [rows * cols];
        int pathLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(hasPathCore(matrix, rows, cols, i, j, visited, pathLen, str)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, int[] visited, int pathLen, char[] str) {
        if (pathLen == str.length) {
            return true;
        }
        boolean hasC = false;
        if (row>=0 && row<rows && col>=0 && col<cols && visited[row * cols + col]==0 && matrix[row * cols + col]==str[pathLen]) {
            visited[row * cols + col] = 1;
            pathLen++;
            hasC = hasPathCore(matrix, rows, cols, row-1, col, visited, pathLen, str) ||
                   hasPathCore(matrix, rows, cols, row+1, col, visited, pathLen, str) ||
                   hasPathCore(matrix, rows, cols, row, col-1, visited, pathLen, str) ||
                   hasPathCore(matrix, rows, cols, row, col+1, visited, pathLen, str);
            if (!hasC) {
                visited[row * cols + col] = 0;
                pathLen--;
            }
        }
        return hasC;
    }
    public static void main(String[] args) {
        Main12 m = new Main12();
        char[] matrix = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
        char[] str = {'A','A','A','A','A','A','A','A','A','A','A','A'};
        System.out.println(m.hasPath(matrix, 3, 4, str));
    }
}
