package org.example.dec2024;

import java.util.HashMap;
import java.util.Map;

public class Dec012024 {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Boolean> map = new HashMap<>();
        int zeroCounter = 0;
        for(int num:arr){
            map.put(num,true);
            if(num==0){
                zeroCounter++;
            }
        }
        if(zeroCounter>1){
            return true;
        }

        for(int num:arr){
            if(num==0){
                continue;
            }
            if(map.getOrDefault(num*2,false)){
                return true;
            }
            if(num%2==0 && map.getOrDefault(num/2,false)){
                return true;
            }
        }
        return false;
    }
}
