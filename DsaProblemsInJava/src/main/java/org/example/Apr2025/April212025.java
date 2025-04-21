package org.example.Apr2025;

import java.util.List;

public class April212025 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long highSum = 0;
        long lowSum = 0;
        long sm = 0;
        for(int i=0;i<differences.length; i++){
            sm += differences[i];
            highSum = Math.max(sm,highSum);
            lowSum = Math.min(sm,lowSum);
            if(highSum-lowSum> upper -lower){
                return 0;
            }
        }
        long maxVal = upper - highSum;
        long minVal = lower - lowSum;
        if(minVal>maxVal){
            return 0;
        }
        return ((upper-lower)-(int)(highSum - lowSum ))+1;
    }
}
