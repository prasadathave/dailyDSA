package org.example.nov2024;

import java.util.*;

public class Nov302024 {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inCount = new HashMap<>();
        Map<Integer, Integer> outCount = new HashMap<>();

        for (int[] pair : pairs) {
            int begin = pair[0], finish = pair[1];
            graph
                    .computeIfAbsent(begin, k -> new ArrayDeque<>())
                    .add(finish);
            outCount.put(begin, outCount.getOrDefault(begin, 0) + 1);
            inCount.put(finish, inCount.getOrDefault(finish, 0) + 1);
        }

        List<Integer> traversalResult = new ArrayList<>();

        int startVertex = -1;
        for (int vertex : outCount.keySet()) {
            if (outCount.get(vertex) == inCount.getOrDefault(vertex, 0) + 1) {
                startVertex = vertex;
                break;
            }
        }

        if (startVertex == -1) {
            startVertex = pairs[0][0];
        }

        explore(startVertex, graph, traversalResult);

        Collections.reverse(traversalResult);

        int[][] finalPairs = new int[traversalResult.size() - 1][2];
        for (int i = 1; i < traversalResult.size(); i++) {
            finalPairs[i - 1] = new int[] {
                    traversalResult.get(i - 1),
                    traversalResult.get(i),
            };
        }

        return finalPairs;
    }

    public int[][] validArrangement1(int[][] pairs){
        Map<Integer,Boolean> visited = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        List<Integer> newint = new ArrayList<>();

        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inCount = new HashMap<>();
        Map<Integer, Integer> outCount = new HashMap<>();

        for (int[] pair : pairs) {
            int begin = pair[0], finish = pair[1];
            graph
                    .computeIfAbsent(begin, k -> new ArrayDeque<>())
                    .add(finish);
            outCount.put(begin, outCount.getOrDefault(begin, 0) + 1);
            inCount.put(finish, inCount.getOrDefault(finish, 0) + 1);
        }


        int startVertex = -1;
        for (int vertex : outCount.keySet()) {
            if (outCount.get(vertex) == inCount.getOrDefault(vertex, 0) + 1) {
                startVertex = vertex;
                break;
            }
        }

        if (startVertex == -1) {
            startVertex = pairs[0][0];
        }
        stk.push(startVertex);

        while(!stk.isEmpty()){
            int currNode = stk.pop();
            newint.add(currNode);
            visited.put(currNode,true);
            for(int num:graph.get(currNode)){
                stk.push(num);
                graph.get(currNode).remove((Integer)num);
            }
        }

        int[][] resPairs = new int[pairs.length][2];
        for(int i=1; i<newint.size(); i++){
            resPairs[i-1] = new int[]{newint.get(i-1),newint.get(i)};
        }

        return resPairs;
    }

    private void explore(
            int vertex,
            Map<Integer, Deque<Integer>> adjacencyGraph,
            List<Integer> path
    ) {
        Deque<Integer> neighborsList = adjacencyGraph.get(vertex);
        while (neighborsList != null && !neighborsList.isEmpty()) {
            int nextVertex = neighborsList.pollFirst();
            explore(nextVertex, adjacencyGraph, path);
        }
        path.add(vertex);
    }

}
