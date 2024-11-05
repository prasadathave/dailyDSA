package org.example.nov2024;

public class Nov052024 {
    public int minChanges(String s) {
        if(s.length()==0){
            return 0;
        }
        int totalChanges =0;
        for(int i=0; i<s.length(); i+=2){
            if(s.substring(i,i+2).equals("00")|| s.substring(i,i+2).equals("11")){

            }
            else{
                totalChanges+=1;
            }
        }
        return totalChanges;
    }
}
