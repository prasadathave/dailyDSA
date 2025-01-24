package org.example.DSATopicWiseQuestions.ArrayQuestions;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,new ArrayList<>());
        }

        for(int i=0; i<nums.length; i++){
            mp.get(nums[i]).add(i);
        }
        List<List<Integer>> initialResult = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int val = -1*(nums[i]+nums[j]);
                if(mp.get(val)!=null){
                    for(int ind:mp.get(val)){
                        if(ind!=i && ind!=j){
                            List<Integer> sample = new ArrayList<>();
                            sample.add(nums[i]);
                            sample.add(nums[j]);
                            sample.add(-1*(nums[i]+nums[j]));
                            initialResult.add(sample);
                            break;
                        }
                    }
                }
            }
        }

        int[] taken = new int[initialResult.size()];
        Arrays.fill(taken,0);
        List<List<Integer>> finalList = new ArrayList<>();

        for(int i=0; i<taken.length; i++){
            if(taken[i]==1){
                continue;
            }

            for(int j=i+1; j<taken.length; j++){
                if (taken[j]==1){
                    continue;
                }

                List<Integer> trip1 =  initialResult.get(i);
                List<Integer> trip2 =  initialResult.get(j);
                int containsAll = 1;
                for(int t1 : trip1){
                    if(!trip2.contains(t1)){
                        containsAll = 0;
                        break;
                    }
                }
                if(containsAll ==1){
                    taken[j] =1;
                }
            }

            if(taken[i]!=1){
                finalList.add(initialResult.get(i));
                taken[i] = 1;
            }
        }

        return finalList;

    }
}
