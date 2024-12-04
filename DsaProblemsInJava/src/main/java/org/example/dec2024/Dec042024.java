package org.example.dec2024;

public class Dec042024 {
    private int searchInStr1(String str1,char charFroms2, int indexFrom){
        for(int i=indexFrom; i<str1.length(); i++){
            if(str1.charAt(i)==charFroms2 || (((str1.charAt(i)-'a'+1)%26)+'a')==charFroms2){
                return i;
            }
        }
        return -1;
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        int charToLookFrom = 0;
        for(int ind =0; ind<str2.length(); ind++){
            charToLookFrom = searchInStr1(str1,str2.charAt(ind),charToLookFrom)+1;
            if(charToLookFrom==0){
                return false;
            }
        }
        return true;
    }
}
