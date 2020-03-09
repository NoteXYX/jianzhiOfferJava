//顺时针打印矩阵
package com.jianzhi;
import java.util.ArrayList;
import java.util.Arrays;
public class Main29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0 || matrix==null) {
            int [] res = new int[0];
            return res;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int curRows = rows;
        int curCols = cols;
        int start = 0;
        while (start*2<rows && start*2<cols) {
            int col = start;
            int row = start;
            for (col = start; col < curCols; col++)
                arrayList.add(matrix[start][col]);
            col--;
            if (++row < curRows) {
                for (; row < curRows; row++)
                    arrayList.add(matrix[row][col]);
                row--;
                if (--col >= start) {
                    for (; col>=start; col--)
                        arrayList.add(matrix[row][col]);
                    col++;
                    if (--row >= start) {
                        for (; row>start; row--)
                            arrayList.add(matrix[row][col]);
                        row++;
                    }
                }
            }
            start++;
            curCols--;
            curRows--;
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        Main29 m = new Main29();
        int[][] matrix = {{1,2,3,4},
                          {4,5,6,7},
                          {7,8,9,10}};
        System.out.println(Arrays.toString(m.spiralOrder(matrix)));
    }
}
