package org.example.dec2024;

import java.util.HashMap;

public class Dec032024 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder builder = new StringBuilder();
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(i,false);
        }
        for(int spaceNum:spaces){
            map.put(spaceNum,true);
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(i)){
                builder.append(" ");
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
