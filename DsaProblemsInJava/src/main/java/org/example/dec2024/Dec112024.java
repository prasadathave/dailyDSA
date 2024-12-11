package org.example.dec2024;

import java.util.Arrays;

public class Dec112024 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i =0;
        int j = 0;
        int n = nums.length;
        int maxLen = 0;
        while(j<n && i<n){
            while(j<n && i<n && nums[j]-nums[i]<=2*k){
                j++;
            }
            maxLen = Math.max(maxLen,j-i);
            i++;
        }
        return maxLen;
    }
}
