package org.example.Jan012025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Jan242025 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodeCount = graph.length;
        int[] incomingEdges = new int[nodeCount];
        List<List<Integer>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < nodeCount; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCount; i++) {
            for (int neighbor : graph[i]) {
                reversedGraph.get(neighbor).add(i);
                incomingEdges[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodeCount; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }

        boolean[] isSafe = new boolean[nodeCount];
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            isSafe[currentNode] = true;

            for (int neighbor : reversedGraph.get(currentNode)) {
                incomingEdges[neighbor]--;
                if (incomingEdges[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            if (isSafe[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}
