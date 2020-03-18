//丑数
package com.jianzhi;
import java.util.ArrayList;

public class Main49 {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int curMul2 = 0, curMul3 = 0, curMul5 = 0;
        int nextIndex = 0;
        int curMax;
        while (nextIndex < n-1){
            curMax = arrayList.get(nextIndex);
            for (int curNum: arrayList) {
                curMul2 = curNum * 2;
                if (curMul2 > curMax)
                    break;
            }
            for (int curNum: arrayList) {
                curMul3 = curNum * 3;
                if (curMul3 > curMax)
                    break;
            }
            for (int curNum: arrayList) {
                curMul5 = curNum * 5;
                if (curMul5 > curMax)
                    break;
            }
            arrayList.add(getMin(curMul2,curMul3,curMul5));
            nextIndex++;
        }
        return arrayList.get(n-1);
    }
    public int getMin(int... val) {
        int min = Integer.MAX_VALUE;
        for (int num: val) {
            if (num < min)
                min = num;
        }
        return min;
    }
    public static void main(String[] args) {
        Main49 m = new Main49();
        System.out.println(m.nthUglyNumber(11));
    }
}
