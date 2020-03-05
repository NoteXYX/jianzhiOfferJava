//数组查找
package com.jianzhi;
public class Main1 {
    public boolean Find(int target, int[][] array) {
        int line = 0;
        int col = array[0].length-1;
        while (line >= 0 && line < array.length && col >= 0 && col < array[0].length){
            if (array[line][col] == target){
                return true;
            }
            else if (array[line][col] < target){
                line++;
            }
            else if (array[line][col] > target){
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Main1 q = new Main1();
        int[][] arr = {{1,2,3},{4,5,6}};
        System.out.println(q.Find(1, arr));
    }
}


