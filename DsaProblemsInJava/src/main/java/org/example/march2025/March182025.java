package org.example.march2025;

public class March182025 {
    public int longestNiceSubarray(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int left =0;
        int leftOr = nums[0];
        int maxLen = 1;
        for(int right=1; right<nums.length; right++){
            if((leftOr & nums[right] )==0){
                leftOr = (nums[right] | leftOr);
                maxLen = Math.max(maxLen,right-left+1);
            }
            else{
                while(left<right && (leftOr & nums[right])!=0){
                    leftOr^=nums[left];
                    left++;
                }
                if(left==right){
                    leftOr = nums[right];
                }
            }
        }
        return maxLen;
    }
}
