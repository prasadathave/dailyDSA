package org.example.Feb2025;

public class Feb042025 {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = Integer.MIN_VALUE;
        if(nums.length==1){
            return sum;
        }
        for(int i=1; i<nums.length; i++){
            if(maxSum<sum){
                maxSum = sum;
            }
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
            }
            else{
                sum = nums[i];
            }
            if(maxSum<sum){
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
