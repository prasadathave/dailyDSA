package org.example.dec2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec092024 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int start =0;
        int end = 1;
        List<List<Integer>> listOfPairs = new ArrayList<>();

        while(start<nums.length && end<nums.length){
            while(end<nums.length && ((nums[end-1]%2) != nums[end]%2)){
                end++;
            }
            List<Integer> n1 = new ArrayList<>();
            n1.add(start);
            n1.add(end-1);
            listOfPairs.add(n1);
            start = end;
            end = start +1;
        }
        int[] markerArray = new int[nums.length];
        Arrays.fill(markerArray,-1);
        int ld = 0;
        for(List<Integer> lst: listOfPairs){
            for(int i= lst.get(0); i<=lst.get(1); i++){
                markerArray[i] =ld;
            }
            ld++;
        }

        boolean[] b = new boolean[queries.length];
        int index =0;
        for(int[] query: queries){

            int i = query[0];
            int j = query[1];
            if(i==j){
                b[index] = true;
            }
            else{
                // System.out.println(listOfPairs.size());
                if(markerArray[i]==markerArray[j]){
                    b[index] = true;
                }
                else{
                    b[index] = false;
                }
            }

            index++;
        }
        return b;
    }
}
