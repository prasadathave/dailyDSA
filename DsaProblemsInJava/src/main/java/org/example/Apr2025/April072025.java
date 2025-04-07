package org.example.Apr2025;

import java.util.Arrays;

public class April072025 {
    private boolean getAnswer(int[] nums,int currIndex, int currSum,int targetSum, int[][] dp){
        if(currSum==targetSum){
            return true;
        }
        if(currSum>targetSum){
            return false;
        }
        if(currIndex>=nums.length){
            return false;
        }
        if(dp[currIndex][currSum]!=0){
            return dp[currIndex][currSum]==1;
        }
        boolean b1 = getAnswer(nums,currIndex+1,currSum+nums[currIndex],targetSum,dp);
        if(b1){
            dp[currIndex][currSum] = 1;
            return true;
        }
        boolean b2 = getAnswer(nums,currIndex+1,currSum,targetSum,dp);
        if(b2){
            dp[currIndex][currSum] = 1;
            return true;
        }
        dp[currIndex][currSum] = 2;
        return false;
    }

    public boolean canPartition(int[] nums) {
        int sumMax = 0;
        for(int num:nums){
            sumMax+=num;
        }
        if(sumMax%2!=0){
            return false;
        }
        Arrays.sort(nums);
        int targetSum = sumMax/2;
        int[][] dp = new int[nums.length+1][sumMax+1];
        return getAnswer(nums,0,0,targetSum,dp);

        // boolean[] sumPossible = new boolean[sumMax+1];
        // Arrays.fill(sumPossible,false);
        // sumPossible[0] = true;
        // for(int sum1=1; sum1<sumMax+1; sum1++){
        //     for(int n1:nums){
        //         if(sum1>=n1){
        //             sumPossible[sum1]= sumPossible[sum1] || sumPossible[sum1-n1];
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // return sumPossible[sumMax/2];
    }
}
