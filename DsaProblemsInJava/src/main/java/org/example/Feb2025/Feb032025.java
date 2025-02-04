package org.example.Feb2025;

public class Feb032025 {
    public int longestMonotonicSubarray(int[] nums) {
        int left =0;
        int right =0;
        int maxLen = 1;
        int n = nums.length;
        if(n==1){
            return 1;
        }
        while(right<n && left<n){
            while(right<n-1 && nums[right]<nums[right+1]){
                right++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            left = right;
            while(right<n-1 && nums[right]==nums[right+1]){
                right++;
                left++;
            }

            while(right<n-1 && nums[right]>nums[right+1]){
                right++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            left = right;
            if(right==n-1){
                break;
            }
        }

        return maxLen;
    }
}
