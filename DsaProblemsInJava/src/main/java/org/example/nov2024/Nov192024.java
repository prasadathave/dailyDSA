package org.example.nov2024;

import java.util.HashMap;
import java.util.Map;

public class Nov192024 {
    public long maximumSubarraySum(int[] nums, int k) {
        long initSum =0;
        long maxSum =0;
        Map<Integer,Integer> numMap = new HashMap<>();

        int numDupl =0;
        for(int i=0; i<k; i++){
            initSum += nums[i];
            numMap.put(nums[i],numMap.getOrDefault(nums[i],0)+1);
            if(numMap.get(nums[i])>1){
                numDupl++;
            }
        }
        int start =0;
        int end = k-1;
        while(end<nums.length){
            if(numDupl==0){
                if(initSum>maxSum){
                    maxSum = initSum;
                }
            }
            initSum -= nums[start];
            if(numMap.get(nums[start])>1){
                numDupl--;
            }
            numMap.put(nums[start],numMap.get(nums[start])-1);

            start++;
            end++;
            if(end<nums.length){
                initSum+=nums[end];
                numMap.put(nums[end],numMap.getOrDefault(nums[end],0)+1);
                if(numMap.get(nums[end])>1){
                    numDupl++;
                }

            }
        }

        return maxSum;
    }
}
