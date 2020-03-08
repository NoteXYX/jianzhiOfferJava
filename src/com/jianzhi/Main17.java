//打印从1到最大的n位数
package com.jianzhi;
import java.util.*;
public class Main17 {
    public int[] printNumbers(int n) {
        int temp = 1;
        for(int i=0;i<n;i++){
            temp *= 10;
        }
        int[] rec = new int[temp-1];
        int index=0;
        for(int k=1;k<temp;k++){
            rec[index] = k;
            index++;
        }
        return rec;
    }
    public static void main(String[] args) {
        Main17 m = new Main17();
        System.out.println(Arrays.toString(m.printNumbers(3)));
    }
}
