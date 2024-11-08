package org.example.nov2024;

import java.util.Arrays;
import java.util.HashMap;

/**
 * It is a very good question in regards that it looks something but is something else
 *
 */
public class Nov072024 {
    public int largestCombination(int[] candidates) {
        int[] countArr = new int[24];
        for (int i = 0; i < 24; i++) {
            for (int candidate : candidates) {
                if ((candidate & (1 << i)) != 0) {
                    countArr[i]++;
                }
            }
        }
        // Return the maximum count.
        int maxVal = 0;
        for (int currCount : countArr) {
            if (currCount > maxVal) {
                maxVal = currCount;
            }
        }
        return maxVal;
    }

}
