package org.example.Jan012025;

public class Jan162025 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;

        // Check if the length of nums1 and nums2 are even or odd
        if (nums1.length % 2 == 0 && nums2.length % 2 == 0) {
            return 0;
        }

        // Case where nums1 is even and nums2 is odd
        if (nums1.length % 2 == 0 && nums2.length % 2 != 0) {
            for (int elem : nums1) {
                result ^= elem;
            }
        }

        // Case where nums1 is odd and nums2 is even
        if (nums1.length % 2 != 0 && nums2.length % 2 == 0) {
            for (int elem : nums2) {
                result ^= elem;
            }
        }

        // Case where both nums1 and nums2 are odd
        if (nums1.length % 2 != 0 && nums2.length % 2 != 0) {
            for (int elem : nums1) {
                result ^= elem;
            }
            for (int elem : nums2) {
                result ^= elem;
            }
        }

        return result;
    }
}
