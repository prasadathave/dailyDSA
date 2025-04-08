package org.example.Apr2025;

import java.util.HashMap;
import java.util.Map;

public class April082025 {
    private boolean isOne(Map<Integer,Integer> mp){
        for(int num:mp.keySet()){
            if(mp.get(num)>1){
                return false;
            }
        }
        return true;
    }
    public int minimumOperations(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int n = nums.length;
        int op =0;
        while(!isOne(mp)){
            int i1 = op*3;
            int i2 = op*3+1;
            int i3 = op*3+2;
            if(i1<n){
                mp.put(nums[i1],mp.get(nums[i1])-1);
            }
            if(i2<n){
                mp.put(nums[i2],mp.get(nums[i2])-1);
            }
            if(i3<n){
                mp.put(nums[i3],mp.get(nums[i3])-1);
            }
            op++;
        }
        return op;
    }
}
