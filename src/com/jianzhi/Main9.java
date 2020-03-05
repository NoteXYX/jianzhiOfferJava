//变态跳台阶 1 or 2 or ..... or n
package com.jianzhi;
public class Main9 {
    public int JumpFloorII(int target) {
        return (int) Math.pow(2,(target-1));
    }
    public static void main(String[] args) {
        Main9 m = new Main9();
        System.out.println(m.JumpFloorII(3));
    }
}
