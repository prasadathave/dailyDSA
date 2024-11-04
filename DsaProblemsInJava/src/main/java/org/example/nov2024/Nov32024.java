package org.example.nov2024;

import java.util.ArrayList;
import java.util.List;

public class Nov32024 {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            return true;
        }
        List<String> characterList = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            characterList.add(s.substring(i,i+1));
        }

        for(int i =0;i<s.length(); i++){
            String lastChar = characterList.get(characterList.size()-1);
            characterList.remove(characterList.size()-1);
            characterList.add(0,lastChar);

            if(lastChar.equals(goal.substring(0,1))) {
                String newStr = String.join("", characterList);
                if (newStr.equals(goal)) {
                    return true;
                }
            }
        }

        return false;
    }
}
