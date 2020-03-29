//圆圈中最后剩下的数字
package com.jianzhi;

import java.util.ArrayList;

public class Main62 {
    public int lastRemaining(int n, int m) {
        if (n < 1)
            return 0;
        ArrayList<Integer> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ll.add(i);
        }
        int point = 0;
        while (ll.size() > 1) {
            point = (point+m-1) % ll.size();
            ll.remove(point);
        }
        return ll.get(0);
    }

    public static void main(String[] args) {
        Main62 m = new Main62();
        System.out.println(m.lastRemaining(10,17));
    }
}
