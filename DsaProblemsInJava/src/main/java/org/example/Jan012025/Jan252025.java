package org.example.Jan012025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Jan252025 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) sortedNums[i] = nums[i];
        Arrays.sort(sortedNums);

        int currentGroup = 0;
        HashMap<Integer, Integer> valueToGroup = new HashMap<>();
        valueToGroup.put(sortedNums[0], currentGroup);

        HashMap<Integer, LinkedList<Integer>> groupToElements = new HashMap<>();
        groupToElements.put(
                currentGroup,
                new LinkedList<Integer>(Arrays.asList(sortedNums[0]))
        );

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(sortedNums[i] - sortedNums[i - 1]) > limit) {
                currentGroup++;
            }

            valueToGroup.put(sortedNums[i], currentGroup);

            if (!groupToElements.containsKey(currentGroup)) {
                groupToElements.put(currentGroup, new LinkedList<Integer>());
            }
            groupToElements.get(currentGroup).add(sortedNums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int group = valueToGroup.get(value);
            nums[i] = groupToElements.get(group).pop();
        }

        return nums;
    }

}
