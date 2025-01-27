package org.example.Jan012025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Jan272025 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[][] mapping = new int[numCourses][numCourses];

        for(int[] pr:prerequisites){
            int c1 = pr[0];
            int c2 = pr[1];
            mapping[c2][c1] = 1;
        }

        for(int course=0; course<numCourses; course++){
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=0; i<numCourses; i++){
                if(mapping[course][i]==1){
                    q.offer(i);
                }
            }


            while(!q.isEmpty()){
                int n = q.poll();
                mapping[course][n] = 1;
                for(int k=0; k<numCourses; k++){
                    if(mapping[n][k]==1 && mapping[course][k]!=1){
                        q.offer(k);
                    }
                }
            }
        }


        List<Boolean> ls = new ArrayList<>();

        for(int[] query: queries){
            int pr = query[0];
            int c = query[1];
            if(mapping[c][pr]==1){
                ls.add(true);
            }
            else{
                ls.add(false);
            }
        }
        return ls;
    }
}
