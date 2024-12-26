package org.example.dec2024;

public class Dec262024 {
    public int getNumWays(int[] nums, int target, int currentSum,int currentIndex){
        if(currentSum==target && currentIndex==nums.length){
            return 1;
        }
        if(currentIndex==nums.length){
            return 0;
        }
        return getNumWays(nums,target,currentSum+nums[currentIndex],currentIndex+1) +
                getNumWays(nums,target,currentSum-nums[currentIndex],currentIndex+1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return getNumWays(nums,target,0,0);
    }
}
