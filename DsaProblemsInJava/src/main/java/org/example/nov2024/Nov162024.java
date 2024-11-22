package org.example.nov2024;

public class Nov162024 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Slide through all subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;

            // Check if the current subarray is consecutive and sorted
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j + 1] != nums[j] + 1) {
                    isConsecutive = false;
                    break;
                }
            }

            // If the subarray is consecutive and sorted, return the max element
            if (isConsecutive) {
                result[i] = nums[i + k - 1];  // Max value will be the last element in the subarray
            } else {
                result[i] = -1;  // Otherwise, return -1
            }
        }

        return result;
    }
}
