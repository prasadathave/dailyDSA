package org.example.dec2024;

import java.util.PriorityQueue;

public class Dec072024 {
    public int minimumSize(int[] nums, int maxOperations) {
        int lowerBound = 1;
        int upperBound = 0;

        for (int bag : nums) {
            upperBound = Math.max(upperBound, bag);
        }

        while (lowerBound < upperBound) {
            int middle = (lowerBound + upperBound) / 2;

            if (canDistribute(middle, nums, maxOperations)) {
                upperBound = middle;
            } else {
                lowerBound = middle + 1;
            }
        }

        return lowerBound;
    }

    private boolean canDistribute(int maxBagSize, int[] nums, int maxOperations) {
        int requiredOperations = 0;

        for (int bag : nums) {
            int splits = (int) Math.ceil(bag / (double) maxBagSize) - 1;
            requiredOperations += splits;

            if (requiredOperations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}
