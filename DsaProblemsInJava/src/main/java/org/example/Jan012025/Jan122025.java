package org.example.Jan012025;

public class Jan122025 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if (n % 2 == 1) {
            return false;
        }
        int left = 0;
        int free = 0;

        for (int j = 0; j < n; j++) {
            if (locked.charAt(j) == '0') {
                free++;
            } else if (s.charAt(j) == '(') {
                left++;
            } else if (s.charAt(j) == ')') {
                if (left > 0) {
                    left--;
                } else if (free > 0) {
                    free--;
                } else {
                    return false;
                }
            }
        }

        int diff = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (locked.charAt(j) == '0') {
                diff--;
                free--;
            } else if (s.charAt(j) == '(') {
                diff++;
                left--;
            } else if (s.charAt(j) == ')') {
                diff--;
            }
            if (diff > 0) {
                return false;
            }
            if (free == 0 && left == 0) {
                break;
            }
        }

        if (left > 0) {
            return false;
        }

        return true;
    }
}
