package org.example.oct2024;

import java.lang.reflect.Array;
import java.util.Arrays;

public class oct302024 {
    private boolean isMountain(int[] nums){
        if(nums.length<3){
            return false;
        }
        boolean isPeakFound = false;
        int peakIndex = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1] && !isPeakFound){
                isPeakFound = true;
                peakIndex = i;
            }
            if(nums[i]<nums[i+1] && isPeakFound){
                return false;
            }
        }
        return isPeakFound && peakIndex!=0;
    }

    public int minimumMountainRemovals(int[] nums) {
        // We want to see if we want to take an element or not
        // Once we take it we check
        int[] ldsCounts = new int[nums.length];
        int[] lisCounts = new int[nums.length];

        Arrays.fill(ldsCounts,1);
        Arrays.fill(lisCounts,1);

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]>nums[i]){
                    lisCounts[j] = Math.max(lisCounts[j],lisCounts[i]+1);
                }
            }
        }


        for(int i=nums.length-1; i>=1; i--){
            for(int j= i-1; j>=0; j--){
                if(nums[j]>nums[i]){
                    ldsCounts[j] = Math.max(ldsCounts[j],ldsCounts[i]+1);
                }
            }
        }
        int minRemovals = nums.length;
        for(int i=0; i<nums.length; i++){
            if(lisCounts[i]>1 && ldsCounts[i]>1) {
                int removals = nums.length - lisCounts[i] - ldsCounts[i] + 1;
                if (removals < minRemovals) {
                    minRemovals = removals;
                }
            }
        }
        return minRemovals;

    }
}
