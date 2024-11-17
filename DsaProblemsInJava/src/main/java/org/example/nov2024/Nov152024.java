package org.example.nov2024;

import java.util.ArrayList;
import java.util.List;

public class Nov152024 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int endIndex = arr.length - 1;
        while (endIndex > 0 && arr[endIndex] >= arr[endIndex - 1]) {
            endIndex--;
        }

        int result = endIndex;
        int startIndex = 0;
        while (startIndex < endIndex && (startIndex == 0 || arr[startIndex - 1] <= arr[startIndex])) {
            // find next valid number after arr[startIndex]
            while (endIndex < arr.length && arr[startIndex] > arr[endIndex]) {
                endIndex++;
            }
            // save length of removed subarray
            result = Math.min(result, endIndex - startIndex - 1);
            startIndex++;
        }
        return result;
    }
}
