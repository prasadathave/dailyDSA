package org.example.nov2024;

public class Nov202024 {
    public int takeCharacters(String s, int k) {
        int[] charCount = new int[3];
        int length = s.length();

        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (int i = 0; i < 3; i++) {
            if (charCount[i] < k) return -1;
        }

        int[] currentWindow = new int[3];
        int start = 0, longestWindow = 0;

        for (int end = 0; end < length; end++) {
            currentWindow[s.charAt(end) - 'a']++;

            while (
                    start <= end &&
                            (charCount[0] - currentWindow[0] < k ||
                                    charCount[1] - currentWindow[1] < k ||
                                    charCount[2] - currentWindow[2] < k)
            ) {
                currentWindow[s.charAt(start) - 'a']--;
                start++;
            }

            longestWindow = Math.max(longestWindow, end - start + 1);
        }

        return length - longestWindow;
    }
}
