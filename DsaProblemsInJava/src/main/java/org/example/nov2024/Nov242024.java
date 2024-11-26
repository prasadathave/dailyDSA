package org.example.nov2024;

public class Nov242024 {
    public long maxMatrixSum(int[][] matrix) {
        long total = 0;
        int smallestAbs = Integer.MAX_VALUE;
        int negativeElements = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                total += Math.abs(element);
                if (element < 0) {
                    negativeElements++;
                }
                smallestAbs = Math.min(smallestAbs, Math.abs(element));
            }
        }

        // Adjust if the count of negative numbers is odd
        if (negativeElements % 2 != 0) {
            total -= 2 * smallestAbs;
        }

        return total;
    }
}
