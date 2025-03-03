package org.example.march2025;

import java.util.ArrayList;
import java.util.List;

public class March022025 {
    public int[] applyOperations(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1] =0;
            }
        }
        List<Integer> nonZeros = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        for(int num:nums){
            if(num!=0){
                nonZeros.add(num);
            }
            else{
                zeros.add(num);
            }
        }
        nonZeros.addAll(zeros);
        for(int i=0; i<nums.length; i++){
            nums[i] = nonZeros.get(i);
        }
        return nums;
    }
}
