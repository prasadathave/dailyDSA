package org.example.Feb2025;

import java.util.HashMap;
import java.util.Map;

public class Feb092025 {
    public long countBadPairs(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();


        for(int i=0; i<nums.length; i++){
            if(mp.getOrDefault(nums[i]-i,null)==null){
                mp.put(nums[i]-i,0);
            }
            mp.put(nums[i]-i,mp.get(nums[i]-i)+1);
        }
        for(int i=0; i<nums.length; i++){
            cnt+=(nums.length-mp.get(nums[i]-i));
        }
        cnt=cnt/2;
        return cnt;
    }


}
