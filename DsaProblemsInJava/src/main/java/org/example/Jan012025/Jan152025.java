package org.example.Jan012025;

import java.util.ArrayList;

public class Jan152025 {
    public int minimizeXor(int num1, int num2) {
        ArrayList<Integer> num1Arr = new ArrayList<>();
        ArrayList<Integer> num2Arr = new ArrayList<>();

        int num1c = num1;
        int num2c = num2;

        while (num1c != 0) {
            num1Arr.add(0, num1c % 2);
            num1c /= 2;
        }

        while (num2c != 0) {
            num2Arr.add(0, num2c % 2);
            num2c /= 2;
        }

        int oneCounter = 0;
        for (int elem : num2Arr) {
            if (elem == 1) {
                oneCounter++;
            }
        }

        while (num2Arr.size() > num1Arr.size()) {
            num1Arr.add(0, 0);
        }
        while (num1Arr.size() > num2Arr.size()) {
            num2Arr.add(0, 0);
        }

        ArrayList<Integer> num3Arr = new ArrayList<>();

        for (int elem : num1Arr) {
            if (elem == 0) {
                num3Arr.add(0);
            } else if (oneCounter > 0 && elem == 1) {
                num3Arr.add(1);
                oneCounter--;
            } else {
                num3Arr.add(0);
            }
        }

        if (oneCounter > 0) {
            for (int i = num3Arr.size() - 1; i >= 0; i--) {
                if (oneCounter > 0 && num3Arr.get(i) == 0) {
                    num3Arr.set(i, 1);
                    oneCounter--;
                }
            }
        }

        int factor = 1;
        int number = 0;

        for (int i = num3Arr.size() - 1; i >= 0; i--) {
            number += factor * num3Arr.get(i);
            factor *= 2;
        }

        return number;
    }
}
