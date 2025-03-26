package org.example.march2025;

public class March192025 {
    public int minOperations(int[] nums) {
        int op =0;

        for(int i=2; i<nums.length; i++){
            if(nums[i-2]==0){
                op++;
                for(int k =0; k<3; k++){
                    nums[i-k] = nums[i-k]^1;
                }
            }
        }
        int sm =0;
        for(int num:nums){
            sm+=num;
        }
        if(sm!=nums.length){
            return -1;
        }
        return op;

    }
}
