package org.example.dec2024;

public class Dec272024 {
    public int maxScoreSightseeingPair(int[] values) {
        int length = values.length;
        int[] maxLeftScores = new int[length];
        maxLeftScores[0] = values[0];

        int bestScore = 0;

        for (int index = 1; index < length; index++) {
            int currentRightValue = values[index] - index;
            bestScore = Math.max(
                    bestScore,
                    maxLeftScores[index - 1] + currentRightValue
            );

            int currentLeftValue = values[index] + index;
            maxLeftScores[index] = Math.max(maxLeftScores[index - 1], currentLeftValue);
        }

        return bestScore;
    }

}
