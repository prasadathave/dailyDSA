package org.example.dec2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec282024 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int length = nums.length - k + 1;

        int[] subarraySums = new int[length];
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        subarraySums[0] = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            subarraySums[i - k + 1] = currentSum;
        }

        int[][] cache = new int[length][4];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        List<Integer> resultIndices = new ArrayList<>();

        findOptimalSum(subarraySums, k, 0, 3, cache);

        reconstructPath(subarraySums, k, 0, 3, cache, resultIndices);

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = resultIndices.get(i);
        }

        return result;
    }

    private int findOptimalSum(int[] subarraySums, int k, int startIdx, int remaining, int[][] cache) {
        if (remaining == 0) return 0;
        if (startIdx >= subarraySums.length) {
            return remaining > 0 ? Integer.MIN_VALUE : 0;
        }

        if (cache[startIdx][remaining] != -1) {
            return cache[startIdx][remaining];
        }

        int includeCurrent = subarraySums[startIdx] + findOptimalSum(subarraySums, k, startIdx + k, remaining - 1, cache);
        int excludeCurrent = findOptimalSum(subarraySums, k, startIdx + 1, remaining, cache);

        cache[startIdx][remaining] = Math.max(includeCurrent, excludeCurrent);
        return cache[startIdx][remaining];
    }

    private void reconstructPath(
            int[] subarraySums,
            int k,
            int startIdx,
            int remaining,
            int[][] cache,
            List<Integer> resultIndices
    ) {
        if (remaining == 0) return;
        if (startIdx >= subarraySums.length) return;

        int includeCurrent = subarraySums[startIdx] + findOptimalSum(subarraySums, k, startIdx + k, remaining - 1, cache);
        int excludeCurrent = findOptimalSum(subarraySums, k, startIdx + 1, remaining, cache);

        if (includeCurrent >= excludeCurrent) {
            resultIndices.add(startIdx);
            reconstructPath(subarraySums, k, startIdx + k, remaining - 1, cache, resultIndices);
        } else {
            reconstructPath(subarraySums, k, startIdx + 1, remaining, cache, resultIndices);
        }
    }
}
