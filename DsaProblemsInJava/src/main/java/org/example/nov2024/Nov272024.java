package org.example.nov2024;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Nov272024 {
    private List<Integer>[] initGraph(int n){
        List<Integer>[] arr = new ArrayList[n];
        int i =0;
        for(int ind = 0; ind<n; ind++){
            arr[ind] = new ArrayList<>();
        }

        for(List<Integer> val:arr){
            if(i!=n-1){
                val.add(i+1);
            }
            i++;
        }

        return arr;

    }

    private void addNode(List<Integer>[] graph,int[] query){
        graph[query[0]].add(query[1]);
    }

    private int getMinimumFromZeroToEnd(List<Integer>[] graph){
        int[] distances = new int[graph.length];
        for(int i=1; i<graph.length; i++){
            distances[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);
        int[] visited = new int[graph.length];
        visited[0] =1;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            visited[curr] =1;
            for(int elem : graph[curr]){
                distances[elem] = Math.min(distances[curr]+1,distances[elem]);
                if(visited[elem]!=1){
                    queue.offer(elem);
                }
            }
        }
        return distances[graph.length-1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] answers = new int[queries.length];
        int endConnected = 0;
        int index =0;
        List<Integer>[] graph = initGraph(n);



        for(int[] query:queries){
            if(query[0]==0 && query[1]==n-1){
                endConnected =1;
            }
            if(endConnected==1){
                answers[index] = 1;
                index++;
                continue;
            }
            addNode(graph,query);
            answers[index] = getMinimumFromZeroToEnd(graph);
            index++;
        }
        return answers;
    }
}
