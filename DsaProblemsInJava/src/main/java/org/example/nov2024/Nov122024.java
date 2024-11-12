package org.example.nov2024;

import java.util.Arrays;
import java.util.Comparator;

public class Nov122024 {
    public int binarySearchTheRequiredIndex(int query, int[][] items){
        int left =0;
        int right = items.length-1;
        int mid = left + (right-left)/2;
        while(left<right){
            mid = left + (right-left)/2;
            // We reached at the max point
            if(items[mid][0]<=query && mid<items.length-1 && items[mid+1][0]>query){
                return mid;
            }
            if (items[mid][0]>query){
                right = mid;
            }
            if(items[mid][0]<=query){
                left = mid;
            }
        }
        return mid;
    }



    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int[] answer = new int[queries.length];
        int[] maxBeautyUpToIndex = new int[items.length];
        int m1 = 0;
        for(int i=0; i< items.length; i++){
            if(m1<items[i][0]){
                m1 = items[i][0];
            }
            maxBeautyUpToIndex[i] = m1;
        }

        int answerIndex =0;
        for(int query:queries){
            int index = binarySearchTheRequiredIndex(query,items);
            System.out.println("index we got - "+index);
            int maxBeauty = maxBeautyUpToIndex[index];

            answer[answerIndex] = maxBeauty;
            answerIndex++;
        }
        return answer;
    }
}
