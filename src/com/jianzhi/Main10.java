//矩阵覆盖
package com.jianzhi;
public class Main10 {
    public int RectCover(int target) {
        int fnm1 = 2;
        int fnm2 = 1;
        if (target == 1) {
            return fnm2;
        }
        if (target == 2) {
            return fnm1;
        }
        int f = 0;
        for (int i = 3; i <= target; i++) {
            f = fnm1 + fnm2;
            fnm2 = fnm1;
            fnm1 = f;
        }
        return f;
    }
    public static void main(String[] args) {
        Main10 m = new Main10();
        System.out.println(m.RectCover(3));
    }
}
