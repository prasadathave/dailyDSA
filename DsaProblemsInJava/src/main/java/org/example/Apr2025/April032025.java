package org.example.Apr2025;

public class April032025 {
    public long maximumTripletValue(int[] nums) {
        int[] rightMax = new int[nums.length];
        int[] leftMax = new int[nums.length];
        int lMax = 0;
        for(int i=0; i<nums.length; i++){
            leftMax[i] = lMax;
            lMax = Math.max(lMax,nums[i]);
        }
        int rMax = 0;
        for(int i = nums.length-1; i>=0; i--){
            rightMax[i] = rMax;
            rMax = Math.max(rMax,nums[i]);
        }
        long max = 0;
        for(int i=1; i<nums.length; i++){
            long res = ((long)leftMax[i]-(long)nums[i]) * (long)(rightMax[i]);
            max = Math.max(res,max);
        }

        return max;
    }
}
