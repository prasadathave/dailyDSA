package org.example.Jan012025;

import java.util.ArrayList;
import java.util.List;

public class Jan102025 {
    private int[] getMaxCountsVal(String[] words2){
        int[] finalAns = new int[26];
        for(String word:words2){
            int[] sample = new int[26];
            for(int i=0; i<word.length(); i++){
                sample[word.charAt(i)-'a']++;
            }
            for(int i=0; i<26; i++){
                finalAns[i] = Math.max(sample[i],finalAns[i]);
            }
        }
        return finalAns;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] requiredCounts = getMaxCountsVal(words2);
        List<String> answerList = new ArrayList<>();
        for(String word:words1){
            int[] wordCounts = new int[26];
            for(int i=0; i<word.length(); i++){
                wordCounts[word.charAt(i)-'a']++;
            }
            boolean isGood = true;
            for(int i=0; i<26; i++){
                if(requiredCounts[i]>wordCounts[i]){
                    isGood = false;
                    break;
                }
            }
            if(isGood){
                answerList.add(word);
            }
        }
        return answerList;
    }
}
