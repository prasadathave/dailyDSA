package org.example.Feb2025;

import java.util.*;


public class Feb122025 {
    private int getDigitSum(int n){
        int sum =0;
        while(n!=0){
            sum += n%10;
            n = (n-n%10)/10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> sumNumMap = new HashMap<>();
        for(int num:nums){
            int sum = getDigitSum(num);
            if(sumNumMap.getOrDefault(sum,null)==null){
                sumNumMap.put(sum,new ArrayList<>());
            }
            sumNumMap.get(sum).add(num);
        }
        int maxSum = -1;
        for(int sm: sumNumMap.keySet()){
            if(sumNumMap.get(sm).size()>=2){
                Collections.sort(sumNumMap.get(sm));
                int sz = sumNumMap.get(sm).size();
                int s1 = sumNumMap.get(sm).get(sz-1)+sumNumMap.get(sm).get(sz-2);
                if(maxSum<s1){
                    maxSum = s1;
                }
            }

        }
        return maxSum;
    }
}

