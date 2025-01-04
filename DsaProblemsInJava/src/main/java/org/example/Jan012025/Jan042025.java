package org.example.Jan012025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Jan042025 {
    private int getMinIndexForACharacter(String s, char c){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                return i;
            }
        }
        return -1;
    }
    private int getMaxIndexForACharacter(String s, char c){
        for(int i =s.length()-1; i>=0; i--){
            if(s.charAt(i)==c){
                return i;
            }
        }
        return -1;
    }
    public int countPalindromicSubsequence(String s) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<26; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<26; i++){
            list.get(i).add(getMinIndexForACharacter(s,(char)(i+'a')));
            list.get(i).add(getMaxIndexForACharacter(s,(char)(i+'a')));
        }
        int counter = 0;
        for(int i=0; i<26; i++){
            HashSet<Character> h1 = new HashSet<>();
            for(int start = list.get(i).get(0)+1; start<list.get(i).get(1); start++){
                h1.add(s.charAt(start));
            }
            counter+=h1.size();
        }
        return counter;
    }
}
