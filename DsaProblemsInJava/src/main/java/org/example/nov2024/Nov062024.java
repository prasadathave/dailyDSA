package org.example.nov2024;

public class Nov062024 {
    private int numberOfSetBits(int number){
        int bits =0;
        while(number!=0){
            bits+= number%2;
            number = (number - number%2)/2;
        }
        return bits;
    }


    public boolean canSortArray(int[] nums) {

        for(int i=0; i<nums.length; i ++){
            boolean isSwapped = false;
            for(int j =1; j<nums.length; j++){
                int setBitsi = numberOfSetBits(nums[j]);
                int setBitsj = numberOfSetBits(nums[j-1]);
                if(nums[j-1]>nums[j] && setBitsi==setBitsj){
                    int c = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] =c;
                    isSwapped = true;
                }

            }
        }

        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]<nums[i]){
                return false;
            }
        }

        return true;

    }
}
