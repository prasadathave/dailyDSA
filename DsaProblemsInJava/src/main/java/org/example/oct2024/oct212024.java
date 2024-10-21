package org.example.oct2024;

import java.util.HashSet;
import java.util.Set;

public class oct212024 {

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        int[] maxCount = new int[1];
        //maxCount[0] =0;
        findMaxRecursive(s,0,set,0,maxCount);
        return maxCount[0];
    }

    private void findMaxRecursive(String s, int startIndex, Set<String> exploredStrings, int currentCount, int[] maxCount) {
        if (currentCount + (s.length() - startIndex) <= maxCount[0]) {
            return;
        }
        if (startIndex == s.length()) {
            maxCount[0] = Math.max(maxCount[0], currentCount);
            return;
        }
        for (int end = startIndex + 1; end <= s.length(); ++end) {
            String substring = s.substring(startIndex, end);
            // If the substring is unique
            if (!exploredStrings.contains(substring)) {
                // Add
                exploredStrings.add(substring);
                // Count for the substrings
                findMaxRecursive(s, end, exploredStrings, currentCount + 1, maxCount);
                // remove and go for new one
                exploredStrings.remove(substring);
            }
        }

    }

}
