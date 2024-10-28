package org.example.oct2024;

import java.util.*;
import java.util.stream.Collectors;

public class oct282024 {
    public int longestSquareStreak(int[] nums) {
        int maxSequenceLength =0;
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }

        Set<Integer> integerSet = new HashSet<>(list);

        for(Integer currentInteger: integerSet){
            int SeqCounter = 0;
            int powerNum = currentInteger;
            while(integerSet.contains(powerNum)){
                powerNum = powerNum*powerNum;
                SeqCounter++;
            }
            if(SeqCounter>maxSequenceLength){
                maxSequenceLength = SeqCounter;
            }

        }
        if(maxSequenceLength>=2){
            return maxSequenceLength;
        }
        return -1;
    }
}
