package org.example.nov2024;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nov012024 {
    // We had to remove the three consecutive to 2
    public String makeFancyString(String s) {
        if(s.length()<=2){
            return s;
        }
        StringBuilder newStr = new StringBuilder();
        int cntr=1;
        char currentChar = s.charAt(0);
        newStr.append(currentChar);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==currentChar){
                cntr++;
            }
            else{
                currentChar = s.charAt(i);
                cntr= 1;
            }
            if(cntr<3){
                newStr.append(s.charAt(i));
            }
        }

        return newStr.toString();
    }
}
