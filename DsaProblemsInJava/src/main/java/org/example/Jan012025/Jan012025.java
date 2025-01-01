package org.example.Jan012025;

public class Jan012025 {
    public int maxScore(String s) {
        int ones =0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='1'){
                ones++;
            }
        }
        int maxScore = -1;
        int zeroCounter =0;
        for(int i=0; i<s.length()-1; i++){
            char c = s.charAt(i);
            if(c=='1'){
                ones--;
            }
            else{
                zeroCounter++;
            }
            int score = ones + zeroCounter;
            if(score>maxScore){
                maxScore = score;
            }
        }

        return maxScore;
    }
}
