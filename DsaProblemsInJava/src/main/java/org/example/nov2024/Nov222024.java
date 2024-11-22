package org.example.nov2024;

import java.util.HashMap;
import java.util.Map;

public class Nov222024 {
    private boolean isRowEqual(int row1, int row2,int[][] matrix){
        int[] arr1 = matrix[row1];
        int[] arr2 = matrix[row2];

        for(int i=0; i<arr1.length; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }

        return true;
    }
    private boolean isRowFlip(int row1, int row2, int[][] matrix){
        int[] arr1 = matrix[row1];
        int[] arr2 = matrix[row2];
        for(int i=0; i<arr1.length; i++){
            if(arr1[i]==arr2[i]){
                return false;
            }
        }
        return true;
    }

    private String getSameString(int rowNumber, int[][] matrix){
        int[] currRow = matrix[rowNumber];
        StringBuilder s1 = new StringBuilder();
        for(int c1:currRow){
            s1.append(c1);
        }
        return s1.toString();
    }

    private String getFlippedString(int rowNumber, int[][] matrix){
        int[] currRow = matrix[rowNumber];
        StringBuilder s1 = new StringBuilder();
        for(int c1:currRow){
            c1 = ((c1==0)?1:0);
            s1.append(c1);
        }
        return s1.toString();
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {

        // Brute force
        // flip each role and call recursively for the count
        // unflip it at last
        // rows either have to be same or flip to be counted as the maxEqual number
        // for each row count such rows and
        int numRows = matrix.length;
        // boolean[] visitedArr = new boolean[numRows];

        // int maxcntr = 0;
        // for(int i=0; i<numRows; i++){
        //     if(visitedArr[i]){
        //         continue;
        //     }
        //     int cntr =0;
        //     for(int j=0; j<numRows; j++){
        //         if(visitedArr[j]){
        //             continue;
        //         }
        //         if(isRowEqual(i,j,matrix)||isRowFlip(i,j,matrix)){
        //             cntr++;
        //             visitedArr[j] = true;
        //         }
        //     }
        //     if(cntr>maxcntr){
        //         maxcntr = cntr;
        //     }

        // }
        // return maxcntr;

        Map<String,Integer> countMap = new HashMap<>();
        for(int i=0; i<numRows; i++){
            String sameStr = getSameString(i,matrix);
            String flippedString = getFlippedString(i,matrix);
            countMap.put(sameStr,countMap.getOrDefault(sameStr,0)+1);
            countMap.put(flippedString,countMap.getOrDefault(flippedString,0)+1);
        }
        int maxCntr =0;
        for(String s1:countMap.keySet()){
            if(countMap.get(s1)>maxCntr){
                maxCntr = countMap.get(s1);
            }
        }
//        System.gc();
        return maxCntr;
    }
}
