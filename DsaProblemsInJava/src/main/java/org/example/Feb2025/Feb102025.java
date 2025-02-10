package org.example.Feb2025;

import java.util.ArrayList;
import java.util.List;

public class Feb102025 {
    private boolean isDigit(String s,int index){
        char c = s.charAt(index);
        if(c-'0'<=9 && c-'0'>=0){
            return true;
        }
        return false;
    }
    public String clearDigits(String s) {
        List<Character> lst = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(isDigit(s,i)){
                lst.remove(lst.size()-1);
            }
            else{
                lst.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:lst){
            sb.append(c);
        }
        return sb.toString();
    }
}
