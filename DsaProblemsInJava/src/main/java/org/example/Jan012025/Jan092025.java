package org.example.Jan012025;

public class Jan092025 {
    public int prefixCount(String[] words, String pref) {
        int counter =0;
        for(String word: words){
            if(word.startsWith(pref)){
                counter++;
            }
        }
        return counter;
    }
}
