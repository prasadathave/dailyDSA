package org.example.Feb2025;

public class Feb012025 {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1){
            return true;
        }
        for(int i=0; i<nums.length-1; i++){
            if((nums[i+1]+nums[i])%2==0){
                return false;
            }
        }
        return true;
    }
}
