package org.example.nov2024;

import java.util.List;
import java.util.Locale;

public class Nov022024 {
    public boolean isCircularSentence(String sentence) {

        String[] strList = sentence.split(" ");
        if(strList.length==1){
            if(strList[0].charAt(0)==strList[0].charAt(strList[0].length()-1)){
                return true;
            }
            else {
                return false;
            }
        }
        boolean isCircular = true;
        for(int i=0; i<strList.length-1; i++){
            String lastString = strList[i];
            String laterString = strList[i+1];
            if(lastString.charAt(lastString.length()-1)!=laterString.charAt(0)){
                isCircular = false;
            }
        }

        String firstStr = strList[0];
        String lastStr = strList[strList.length-1];

        if(firstStr.charAt(0)==lastStr.charAt(lastStr.length()-1)){

        }
        else{
            isCircular = false;
        }

        return isCircular;
    }

}
