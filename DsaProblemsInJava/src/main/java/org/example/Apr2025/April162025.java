package org.example.Apr2025;

import java.util.HashMap;
import java.util.Map;

public class April162025 {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> cntMap = new HashMap<>();
        long total = 0;
        for(int i=0; i<nums.length; i++){
            cntMap.put(nums[i],0);
        }
        int left =0;
        long ansCnt =0;
        for(int i=0; i<nums.length; i++){
            cntMap.put(nums[i],cntMap.get(nums[i])+1);
            int val = cntMap.get(nums[i]);
            total += (long)(val-1);


            while(total>=k && left<i){
                int lval = cntMap.get(nums[left]);
                total -= (lval-1);
                cntMap.put(nums[left],lval-1);
                ansCnt+=nums.length - i;
                left++;
            }
        }

        return ansCnt;
    }
}
