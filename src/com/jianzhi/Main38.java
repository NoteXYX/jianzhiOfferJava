//字符串的排列
package com.jianzhi;
import java.util.Arrays;
import java.util.HashMap;

public class Main38 {
    public String[] permutation(String s) {
        if (s.length()==0 || s==null)
            return new String[0];
        HashMap<String, Integer> map = new HashMap<>();
        StringBuffer sbf = new StringBuffer(s);
        permutationCore(sbf, 0, map);
        String[] res = new String[map.size()];
        int index = 0;
        for (String key: map.keySet()) {
            res[index] = key;
            index++;
        }
        return res;
    }
    public void permutationCore(StringBuffer sbf, int begin, HashMap<String, Integer> map) {
        if (begin == sbf.length()) {
            map.put(sbf.toString(), 1);
        }
        for (int i = begin; i < sbf.length(); i++) {
            swap(sbf, i, begin);
            permutationCore(sbf, begin+1, map);
            swap(sbf, i, begin);
        }
    }
    public void swap(StringBuffer sbf, int i, int j) {
        char tmp = sbf.charAt(i);
        sbf.setCharAt(i,sbf.charAt(j));
        sbf.setCharAt(j, tmp);
    }
    public static void main(String[] args) {
        Main38 m = new Main38();
        String s = "aab";
        System.out.println(Arrays.toString(m.permutation(s)));
    }
}
