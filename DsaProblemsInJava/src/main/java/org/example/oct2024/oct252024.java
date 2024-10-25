package org.example.oct2024;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

public class oct252024 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> baseFolders = new ArrayList<>();
        int firstPointer = 0;
        while(firstPointer<folder.length){
            baseFolders.add(folder[firstPointer]);
            int secondPointer = firstPointer+1;
            while(secondPointer< folder.length){
                String secondString = folder[secondPointer];
                String firstString = folder[firstPointer] + "/";
                if(!secondString.startsWith(firstString)){
                    break;
                }
                secondPointer++;
            }
            firstPointer = secondPointer;
        }
        return baseFolders;
    }
}
