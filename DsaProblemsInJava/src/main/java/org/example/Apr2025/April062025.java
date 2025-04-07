package org.example.Apr2025;

import java.util.ArrayList;
import java.util.List;

public class April062025 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
            List<Integer> thisLst = new ArrayList<>();
            thisLst.add(nums[i]);
            for(int j = 0; j<nums.length; j++){
                if(j==i){
                    continue;
                }
                boolean isGood = true;
                for(int num:thisLst){
                    if((num%nums[j])==0 || (nums[j]%num)==0){
                        continue;
                    }
                    else{
                        isGood= false;
                        break;
                    }
                }

                if(isGood){
                    thisLst.add(nums[j]);
                }
            }

            if(thisLst.size()>lst.size()){
                lst = thisLst;
            }
        }
        return lst;
    }
}
