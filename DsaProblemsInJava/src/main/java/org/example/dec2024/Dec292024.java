package org.example.dec2024;

import java.util.Arrays;

public class Dec292024 {
    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();

        int[][] dp = new int[wordLength][targetLength];
        for (int i = 0; i < wordLength; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[][] freqTable = new int[wordLength][26];

        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                int charIndex = word.charAt(j) - 'a';
                freqTable[j][charIndex]++;
            }
        }

        return (int) findCombinations(words, target, 0, 0, dp, freqTable);
    }

    private long findCombinations(
            String[] words,
            String target,
            int wordPos,
            int targetPos,
            int[][] dp,
            int[][] freqTable
    ) {
        int MOD = 1000000007;

        if (targetPos == target.length()) return 1;

        if (
                wordPos == words[0].length() ||
                        words[0].length() - wordPos < target.length() - targetPos
        ) return 0;

        if (dp[wordPos][targetPos] != -1) return dp[wordPos][targetPos];

        long combinationCount = 0;
        int currentChar = target.charAt(targetPos) - 'a';

        combinationCount += findCombinations(
                words,
                target,
                wordPos + 1,
                targetPos,
                dp,
                freqTable
        );

        combinationCount +=
                freqTable[wordPos][currentChar] *
                        findCombinations(
                                words,
                                target,
                                wordPos + 1,
                                targetPos + 1,
                                dp,
                                freqTable
                        );

        dp[wordPos][targetPos] = (int) (combinationCount % MOD);

        return dp[wordPos][targetPos];
    }

}
