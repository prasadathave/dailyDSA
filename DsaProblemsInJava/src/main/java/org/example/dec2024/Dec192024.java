package org.example.dec2024;

import java.util.HashMap;
import java.util.Map;

public class Dec192024 {
    private boolean doesContainAllUptoi(int[] arr,int end){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<=end; i++){
            mp.put(arr[i],1);
        }
        for(int i=0; i<=end; i++){
            if(mp.getOrDefault(i,0)!=1){
                return false;
            }
        }
        return true;
    }

    private int getMaxChunks(int[] arr, int start,Map<Integer,Integer> mp1){
        int leastValidIndex = -1;
        for(int i=start; i<arr.length; i++){
            if(doesContainAllUptoi(arr,i) && mp1.getOrDefault(i,0)!=1){
                leastValidIndex = i;
                mp1.put(i,1);
                break;
            }
        }
        if(leastValidIndex==-1){
            return 0;
        }
        return 1+ getMaxChunks(arr,leastValidIndex,mp1);
    }

    public int maxChunksToSorted(int[] arr) {
        Map<Integer,Integer> mp1 = new HashMap<>();
        return getMaxChunks(arr,0,mp1);
    }
}
