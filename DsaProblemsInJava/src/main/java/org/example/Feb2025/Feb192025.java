package org.example.Feb2025;

import java.util.ArrayList;
import java.util.List;

public class Feb192025 {
    private char[] chrs = new char[]{'a','b','c'};
    private void generate(String s1,int n,List<String> lst){
        if(s1.length()==0){
            for(char chr:chrs){
                generate(s1+chr,n,lst);
            }
            return;
        }
        if(s1.length()==n){
            lst.add(s1);
            return;
        }

        char lastChar = s1.charAt(s1.length()-1);
        for(char chr:chrs){
            if(chr!=lastChar){
                generate(s1+chr,n,lst);
            }
        }

    }

    public String getHappyString(int n, int k) {

        List<String> lst = new ArrayList<>();
        generate("",n,lst);
        System.out.println(lst.size());
        if(lst.size()<k){
            return "";
        }
        return lst.get(k-1);

    }
}
