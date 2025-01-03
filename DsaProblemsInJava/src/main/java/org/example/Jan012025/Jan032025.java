package org.example.Jan012025;

public class Jan032025 {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for(int num:nums){
            totalSum+=num;
        }

        long leftSum = nums[0];
        int validSplits = 0;
        for(int i=1; i<nums.length-1; i++){
            if(leftSum>=(totalSum-leftSum)){
                validSplits++;
                //System.out.println("valid i -"+i);
            }
            leftSum+=nums[i];
        }

        if(totalSum-nums[nums.length-1]>=nums[nums.length-1]){
            validSplits++;
        }
        return validSplits;
    }
}
