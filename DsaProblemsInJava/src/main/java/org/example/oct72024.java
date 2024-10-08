package org.example;

public class oct72024 {
    public int minLength(String s){
        while(s.contains("AB") || s.contains("CD")){
            while(s.contains("AB")){
                s = s.replace("AB","");
            }
            while(s.contains("CD")){
                s = s.replace("CD","");
            }
        }
        return s.length();
    }
}
