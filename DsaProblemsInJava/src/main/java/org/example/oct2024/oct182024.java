package org.example.oct2024;

public class oct182024 {
        public int getCount(int currIndex,int carriedBitWiseOr,int maxBitwiseOr,int[] nums){
            if(currIndex==nums.length-1 && carriedBitWiseOr == maxBitwiseOr){
                return 2;
            }
            else if(currIndex==nums.length-1 && carriedBitWiseOr != maxBitwiseOr){
                if((carriedBitWiseOr|nums[currIndex])==maxBitwiseOr){
                    return 1;
                }
                else {
                    return 0;
                }
            }
            return getCount(currIndex+1,carriedBitWiseOr|nums[currIndex],maxBitwiseOr,nums)+getCount(currIndex+1,carriedBitWiseOr,maxBitwiseOr,nums);

        }
        public int countMaxOrSubsets(int[] nums) {
            int maxBitWiseOr = 0;
            for(int i:nums){
                maxBitWiseOr = maxBitWiseOr | i;
            }
            return getCount(0,0,maxBitWiseOr,nums);
        }
}
