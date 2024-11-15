package org.example.nov2024;

import java.util.Arrays;

public class Nov132024 {
    long binarySearchForGettingLowestNumberGreater(int[] nums,int left, int right, int number){
        while(left<=right){
            int mid = left + ((right-left)/2);
            if(nums[mid]>=number){
                right = mid -1;
            }
            else{
                left = mid+1;
            }

        }
        return left;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long counter = 0;
        Arrays.sort(nums);
        for(int index=0; index<nums.length; index++){
            long values_smaller_than_lower = binarySearchForGettingLowestNumberGreater(nums,index+1,nums.length-1,lower-nums[index]);
            long values_lower_than_upper = binarySearchForGettingLowestNumberGreater(nums,index+1,nums.length-1,upper-nums[index]+1);

            counter += (values_lower_than_upper-values_smaller_than_lower);

        }
        return counter;
    }
}
