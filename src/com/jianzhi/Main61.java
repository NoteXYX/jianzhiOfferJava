package com.jianzhi;

import java.util.Arrays;

public class Main61 {
    public boolean isContinuous(int [] numbers) {
        if (numbers==null || numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int numOfZero = 0;
        boolean res = true;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                numOfZero++;
            else {
                if (i == numbers.length-1)
                    return true;
                else {
                    if (numbers[i+1] - numbers[i] - 1 > numOfZero || numbers[i+1] == numbers[i])
                        return false;
                    else
                        numOfZero -= numbers[i+1] - numbers[i] - 1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Main61 m = new Main61();
        int[] numbers = {1,3,0,0,6};
        System.out.println(m.isContinuous(numbers));
    }
}