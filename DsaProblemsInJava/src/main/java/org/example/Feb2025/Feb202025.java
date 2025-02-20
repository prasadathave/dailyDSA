package org.example.Feb2025;

public class Feb202025 {
    private String getString(int currIndex,String[] nums){
        if(currIndex==nums.length){
            return "";
        }
        if(nums[currIndex].charAt(currIndex)=='1'){
            return "0"+getString(currIndex+1,nums);
        }
        else{
            return "1"+getString(currIndex+1,nums);
        }

    }
    public String findDifferentBinaryString(String[] nums) {
        return getString(0,nums);
    }
}
