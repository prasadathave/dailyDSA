package org.example.Jan012025;

public class Jan172025 {
    public boolean doesValidArrayExist(int[] derived) {
        int result = 0;
        for(int elem:derived){
            result = result ^ elem;
        }
        return result == 0;
    }
}
