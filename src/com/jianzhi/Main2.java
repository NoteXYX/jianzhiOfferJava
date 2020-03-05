//空格替换
package com.jianzhi;
import java.util.Scanner;
public class Main2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
    public static void main(String[] args) {
        Main2 m = new Main2();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            StringBuffer sbf = new StringBuffer(in.nextLine());
            if (sbf.toString().equals("")){
                break;
            }
            System.out.println(m.replaceSpace(sbf));
        }
    }
}
