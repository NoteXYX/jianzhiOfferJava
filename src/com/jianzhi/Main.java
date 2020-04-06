package com.jianzhi;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
//        Writer writer = new FileWriter("log.txt",true); // 参数二，是否追加文件，true=追加
//        writer.append("老王，你好\n");
//        writer.close();
        Reader reader = new FileReader("log.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer bf = new StringBuffer();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            bf.append(str + "\n");
        }
        bufferedReader.close();
        reader.close();
        System.out.println(bf.toString());
    }
//    public static void main(String[] args) {
//        System.out.println("main start...");
//        Thread t = new Thread() {
//            public void run() {
//                System.out.println("thread run...");
//                try {
//                    Thread.sleep(10);
//                    if(isInterrupted())
//                        return;
//                } catch (InterruptedException e) {}
//                System.out.println("thread end.");
//            }
//        };
//        t.start();
//        t.interrupt();
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {}
//        System.out.println("main end...");
//    }
}
