package com.jianzhi;
import java.util.Scanner;
import java.util.Arrays;
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if (str.equals(""))
                break;
            System.out.println(str.lastIndexOf("a",3));
            String[] strs = str.split(" ");
            StringBuffer sbf = new StringBuffer();
            for (int i=strs.length-1; i>=0; i--){
                sbf.append(strs[i] + " ");
            }
            System.out.println(sbf.toString().trim());
        }
    }
}
