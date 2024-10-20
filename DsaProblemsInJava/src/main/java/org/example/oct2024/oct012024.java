package org.example.oct2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class oct012024 {
    public int getMin(int arr[]){
        int min = arr[0];
        for(int i:arr){
            if(i<min){
                min =i;
            }
        }
        return min;
    }
    public int getAdder(int minNumber,int k){
        if(minNumber>=0){
            return 0;
        }
        if(minNumber%k==0){
            return -1*minNumber;
        }
        if(minNumber+k>=0){
            return k;
        }
        else{
            return -1*(minNumber-((minNumber%k)+k));
        }
    }


    public boolean canArrange(int [] arr, int k){
        // Put everything into a map where you add if not and increment if it exist
        int sum =0;
        for(int s1: arr){
            sum+=s1;
        }
        if(sum%k!=0){
            return false;
        }
        int min = getMin(arr);
        int adder = getAdder(min,k);
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i : arr){
            i = (i+adder)%k;
            countMap.putIfAbsent(i,0);
            countMap.put(i,
                    countMap.get(i)+1);
        }

            for (Integer elem : countMap.keySet()) {
                if (countMap.get(elem) != 0 && countMap.get((k - elem) % k) != null && countMap.get((k - elem) % k) != 0) {
                    if(Objects.equals(countMap.get(elem), countMap.get((k - elem) % k))){
                        countMap.put(elem, 0);
                        countMap.put((k - elem) % k, 0);
                    }

                }
            }
        for(Integer elem : countMap.keySet()){
            if(countMap.get(elem)!=0 && elem !=0 && countMap.get((k-elem)%k)!=null && !Objects.equals(countMap.get((k - elem) % k), countMap.get(elem)) || countMap.get((k-elem)%k)==null){
                System.out.println(elem+ " count of elem "+countMap.get(elem)+" counterpart count  "+ countMap.get((k-elem)%k));
                if(!Objects.equals(countMap.get(elem), countMap.get((k - elem) % k))) {
                    return false;
                }
            }
        }
        return true;
    }
}
