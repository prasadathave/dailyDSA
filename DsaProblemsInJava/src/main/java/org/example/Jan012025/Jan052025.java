package org.example.Jan012025;

public class Jan052025 {
    public String shiftingLetters(String s, int[][] shifts) {
        int length = s.length();
        int[] change = new int[length];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                change[shift[0]]++;
                if (shift[1] + 1 < length) {
                    change[shift[1] + 1]--;
                }
            } else {
                change[shift[0]]--;
                if (shift[1] + 1 < length) {
                    change[shift[1] + 1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);
        int totalShift = 0;

        for (int i = 0; i < length; i++) {
            totalShift = (totalShift + change[i]) % 26;
            if (totalShift < 0) totalShift += 26;

            char newChar = (char) ('a' + ((s.charAt(i) - 'a' + totalShift) % 26));
            sb.setCharAt(i, newChar);
        }

        return sb.toString();
    }

}
