package org.example.Apr2025;

import java.util.Arrays;

public class April012025 {
    private long getAnswer(int[][] questions,int index, long[] dp){
        if(index>=questions.length){
            return 0;
        }
        if(dp[index]!=-1L){
            return dp[index];
        }
        int num = questions[index][1];
        long score1 = questions[index][0] + getAnswer(questions,index+num+1,dp);
        long score2 = getAnswer(questions,index+1,dp);
        long maxVal = score1;
        if(score2>score1){
            maxVal = score2;
        }
        dp[index] = maxVal;
        return maxVal;
    }
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp,-1L);
        return getAnswer(questions,0,dp);
    }
}
