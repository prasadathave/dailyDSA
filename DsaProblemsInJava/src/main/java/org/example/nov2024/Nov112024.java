package org.example.nov2024;

import java.util.ArrayList;
import java.util.List;

public class Nov112024 {
    public boolean checkPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }

        int[] largestPrime = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            if (checkPrime(i)) {
                largestPrime[i] = i;
            } else {
                largestPrime[i] = largestPrime[i - 1];
            }
        }

        for (int idx = 0; idx < nums.length; idx++) {
            int threshold;
            if (idx == 0) {
                threshold = nums[0];
            } else {
                threshold = nums[idx] - nums[idx - 1];
            }

            if (threshold <= 0) {
                return false;
            }

            int primeToSubtract = largestPrime[threshold - 1];
            nums[idx] -= primeToSubtract;
        }
        return true;

    }
}
