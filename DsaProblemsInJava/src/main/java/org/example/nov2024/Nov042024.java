package org.example.nov2024;

public class Nov042024 {
    public String compressedString(String word) {
        StringBuilder compressedWord = new StringBuilder();
        int i=0;
        int j =0;
        int wordLen = word.length();
        while(i<wordLen){
            String currentString = word.substring(i,i+1);
            j =i;
            char currentChar = word.charAt(i);
            while(j<wordLen && currentChar==word.charAt(j)){
                j++;
            }
            StringBuilder getResultString = getCalculatedString(i,j,currentChar);
            i =j;
            compressedWord.append(getResultString);
        }

        return compressedWord.toString();
    }

    private StringBuilder getCalculatedString(int i, int j, char currentChar) {
        int len = j-i;
        StringBuilder finalString  = new StringBuilder();
        while(len>9){
            finalString.append(9);
            finalString.append(currentChar);
            len = len-9;
        }
        if(len>0){
            finalString.append(len);
            finalString.append(currentChar);
        }
        return finalString;
    }
}
