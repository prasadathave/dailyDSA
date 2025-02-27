package org.example.Feb2025;

import java.util.HashMap;
import java.util.Map;

public class Feb272025 {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:arr){
            mp.put(num,1);
        }
        int maxlen =0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int f1 = arr[i];
                int f2 = arr[j];
                int f3 = f1+f2;
                int len = 2;
                while(mp.getOrDefault(f3,0)==1){
                    len++;
                    maxlen = Math.max(len,maxlen);

                    f1 = f2;
                    f2 = f3;
                    f3 = f1+f2;

                }
            }
        }
        return maxlen;

    }
}
