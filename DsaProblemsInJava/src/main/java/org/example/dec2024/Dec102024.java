package org.example.dec2024;

import java.util.HashMap;
import java.util.Map;

public class Dec102024 {
    private boolean isSpecial(String s1){
        char init = s1.charAt(0);
        for(int i =0; i<s1.length(); i++){
            if(s1.charAt(i)!=init){
                return false;
            }
        }
        return true;
    }
    public int maximumLength(String s) {
        Map<String,Integer> map = new HashMap<>();
        for(int i= 0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String s1 = s.substring(i,j);
                if(isSpecial(s1)){
                    int cnt = map.getOrDefault(s1,0);
                    cnt++;
                    map.put(s1,cnt);
                }
            }
        }
        int maxlen =-1;
        String finalstr = "";
        for(String s1: map.keySet()){
            if(map.get(s1)>=3){
                if(s1.length()>maxlen){
                    maxlen = s1.length();
                    finalstr = s1;
                }
            }
        }
        return maxlen;
    }
}
