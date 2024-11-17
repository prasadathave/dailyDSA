package org.example.DSATopicWiseQuestions.SlidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepetition {

    private boolean allOne(Map<Character,Integer> map){
        for(Character c1: map.keySet()){
            if(map.get(c1)>1){
                return false;
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {

        int end =0;
        int start =0;

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i),0);
        }
        int maxWindow = 0;
        while(end<s.length()){
            if(allOne(map)){
                map.put(s.charAt(end),map.get(s.charAt(end))+1);
                if(maxWindow<end-start+1){
                    maxWindow = end - start +1;
                }
                end++;
            }
            else{
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }

        }
        return maxWindow;
    }

}
