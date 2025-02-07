package org.example.Feb2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Feb072025 {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Set<Integer>> colorToBall = new HashMap<>();
        HashMap<Integer,Integer> ballToColor = new HashMap<>();
        int[] answer = new int[queries.length];
        int index =0;
        for(int[] query:queries){
            int ball = query[0];
            int color = query[1];

            if(ballToColor.getOrDefault(ball,null)!=null){
                int origColor = ballToColor.get(ball);
                colorToBall.get(origColor).remove((Integer)ball);
                if(colorToBall.get(origColor).size()==0){
                    colorToBall.keySet().remove((Integer)origColor);
                }
            }
            ballToColor.put(ball,color);
            if(colorToBall.getOrDefault(color,null)==null){
                colorToBall.put(color,new HashSet<>());
            }
            colorToBall.get(color).add(ball);

            answer[index] = colorToBall.keySet().size();
            index++;
        }

        return answer;

    }
}
