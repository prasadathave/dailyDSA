package org.example.Jan012025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Jan302025 {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edg: edges){
            int x = edg[0];
            int y = edg[1];
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        int graphCounter = 1;
        int visitedCounter = 1;

        int[] nodeVals = new int[n+1];
        int[] visited = new int[n+1];

        while(visitedCounter!=n){

            int minDegree = n+1;
            int minDN = -1;
            for(int i=1; i<n+1; i++){
                int deg = adjList.get(i).size();
                if(deg<minDegree && visited[i]!=1){
                    minDN = i;
                    minDegree = deg;
                }
            }

            if(minDN==-1){
                break;
            }

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(minDN);
            nodeVals[minDN] = graphCounter;

            while(!q.isEmpty()){
                int nd = q.poll();
                visited[nd] = 1;
                visitedCounter++;
                for(int nb:adjList.get(nd)){
                    if(nodeVals[nb]==0){
                        nodeVals[nb] = nodeVals[nd]+1;
                        graphCounter = Math.max(nodeVals[nb],graphCounter);
                    }
                    else if(Math.abs(nodeVals[nb]-nodeVals[nd])!=1){
                        return -1;
                    }
                    if(visited[nb]!=1){
                        q.offer(nb);
                    }
                }
            }
            graphCounter +=1;
        }


        int maxVal = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            if(maxVal<nodeVals[i]){
                maxVal = nodeVals[i];
            }
        }

        return maxVal;
    }
}
