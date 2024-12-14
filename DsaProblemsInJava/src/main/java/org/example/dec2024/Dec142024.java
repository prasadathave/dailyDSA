package org.example.dec2024;

import java.util.TreeMap;

public class Dec142024 {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        int start = 0, end = 0;
        int length = nums.length;
        long subarrayCount = 0;

        while (end < length) {
            frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);

            while (frequencyMap.lastEntry().getKey() - frequencyMap.firstEntry().getKey() > 2) {
                frequencyMap.put(nums[start], frequencyMap.get(nums[start]) - 1);
                if (frequencyMap.get(nums[start]) == 0) {
                    frequencyMap.remove(nums[start]);
                }
                start++;
            }

            subarrayCount += end - start + 1;
            end++;
        }

        return subarrayCount;
    }
}
