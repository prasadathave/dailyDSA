package org.example.Feb2025;

public class Feb262025 {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum =0;
        int sum =0;
        for(int i=0;i<nums.length; i++){
            sum+=nums[i];
            if(sum>maxsum){
                maxsum = sum;
            }
            if(sum<0){
                sum =0;
            }
        }
        sum=0;
        int minsum = 0;
        for(int i=0;i<nums.length; i++){
            sum+=nums[i];
            if(sum<minsum){
                minsum = sum;
            }
            if(sum>0){
                sum =0;
            }
        }
        maxsum = Math.abs(maxsum);
        minsum = Math.abs(minsum);
        return Math.max(maxsum,minsum);
    }
}
