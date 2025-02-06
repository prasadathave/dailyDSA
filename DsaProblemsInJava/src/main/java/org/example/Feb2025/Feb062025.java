package org.example.Feb2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feb062025 {
    private boolean isValidPair(List<Integer> l1, List<Integer> l2){
        int a = l1.get(0);
        int b = l1.get(1);
        int c = l2.get(0);
        int d = l2.get(1);

        if(a!=b && a!=c && a!=d && b!=c && b!=d && c!=d){
            return true;
        }
        return false;
    }


    private void printl1l2(List<Integer> l1, List<Integer> l2){
        int a = l1.get(0);
        int b = l1.get(1);
        int c = l2.get(0);
        int d = l2.get(1);

        System.out.println("a,b,c,d- "+a+","+b+","+c+","+d);
    }
    public int tupleSameProduct(int[] nums) {
        Map<Integer,List<List<Integer>>> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            for(int j =i+1; j<nums.length; j++){
                if(nums[i]!=nums[j]){
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(nums[i]);
                    l1.add(nums[j]);
                    int x = nums[i]*nums[j];
                    if(mp.getOrDefault(x,null)==null){
                        mp.put(x,new ArrayList<>());
                    }
                    mp.get(x).add(l1);
                }
            }
        }

        int count =0;
        for(int x:mp.keySet()){
            List<List<Integer>> lst = mp.get(x);

            if(lst.size()>1){
                for(int i=0; i<lst.size(); i++){
                    for(int j=i+1; j<lst.size(); j++){
                        List<Integer> l1 = lst.get(i);
                        List<Integer> l2 = lst.get(j);
                        if(isValidPair(l1,l2)){
                            count+=8;
                        }
                    }
                }
            }
        }
        return count;
    }
}
