package org.example.Feb2025;

public class Feb252025 {
    public int numOfSubarrays(int[] arr) {
        final int MODULO = 1_000_000_007;
        int total = 0, sum = 0;
        int oddCount = 0, evenCount = 1;

        for (int value : arr) {
            sum += value;
            if (sum % 2 == 0) {
                total += oddCount;
                evenCount++;
            } else {
                total += evenCount;
                oddCount++;
            }

            total %= MODULO;
        }

        return total;
    }
}
