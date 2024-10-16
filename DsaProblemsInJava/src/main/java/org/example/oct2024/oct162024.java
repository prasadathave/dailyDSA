package org.example.oct2024;

import java.util.HashMap;
import java.util.Map;

public class oct162024 {
    public String getNonObjectionableMaxChar(Map<String,Integer> contMap,String objectionableString){
        int maxNum =0;
        String answer ="";
        for(String s1 : contMap.keySet()){
            if(s1.equals(objectionableString)){
                continue;
            }
            else if(contMap.get(s1)>maxNum){
                maxNum = contMap.get(s1);
                answer = s1;
            }
        }
        return answer;
    }

    public String longestDiverseString(int a, int b, int c){
        String Astr = "a";
        String Bstr  = "b";
        String Cstr = "c";
        Map<String,Integer> countMap = new HashMap<>();
        countMap.put(Astr,a);
        countMap.put(Bstr,b);
        countMap.put(Cstr,c);
        String constructedString = "";
        String objectionAbleString = "";
        String currentObtainedChar = getNonObjectionableMaxChar(countMap, objectionAbleString);
        while(!currentObtainedChar.isEmpty()){
            constructedString += currentObtainedChar;
            int currCount = countMap.get(currentObtainedChar);
            countMap.put(currentObtainedChar,currCount-1);
            if(constructedString.length()>=2 && constructedString.charAt(constructedString.length()-1)==constructedString.charAt(constructedString.length()-2)){
                currentObtainedChar = getNonObjectionableMaxChar(countMap,constructedString.substring(constructedString.length()-1));
            }
            else{
                currentObtainedChar = getNonObjectionableMaxChar(countMap,"");
            }
        }

        return constructedString;

    }
}
