package org.example.DSATopicWiseQuestions.DPQuestions;

import java.util.List;

public class Triangle {
    private int getMinimumSum(List<List<Integer>> triangle, int currentIndex, int currentLevel){

        int s1 =Integer.MAX_VALUE;
        int s2 =Integer.MAX_VALUE;

        int val = triangle.get(currentLevel).get(currentIndex);
        if(currentLevel+1<triangle.size()){
            s1 = getMinimumSum(triangle,currentIndex,currentLevel+1);
            s2 = getMinimumSum(triangle,currentIndex+1,currentLevel+1);
            System.out.println("s1,s2 - "+s1+" , "+s2);
            val +=  Math.min(s1,s2);
        }

        return val;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return getMinimumSum(triangle,0,0);
    }
}
