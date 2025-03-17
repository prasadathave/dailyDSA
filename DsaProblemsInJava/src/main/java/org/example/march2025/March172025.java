package org.example.march2025;

import java.util.HashMap;
import java.util.Map;

public class March172025 {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(int num:mp.keySet()){
            if(mp.get(num)%2!=0){
                return false;
            }
        }
        return true;
    }
}
