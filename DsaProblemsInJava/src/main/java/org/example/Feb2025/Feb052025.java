package org.example.Feb2025;

public class Feb052025 {
    public boolean isMapSame(int[] s1Counts,int[] s2Counts){
        for(int i=0; i<s1Counts.length; i++){
            if(s1Counts[i]!=s2Counts[i]){
                return false;
            }

        }
        return true;
    }
    public boolean areAlmostEqual(String s1, String s2) {
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        int diffCounter = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diffCounter++;
            }
            s1Counts[s1.charAt(i)-'a']++;
            s2Counts[s2.charAt(i)-'a']++;
        }

        if(diffCounter==0){
            return true;
        }
        if(diffCounter==2){
            return isMapSame(s1Counts,s2Counts);
        }
        return false;
    }
}
