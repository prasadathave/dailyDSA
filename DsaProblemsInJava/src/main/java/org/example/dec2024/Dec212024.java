package org.example.dec2024;

import java.util.ArrayList;
import java.util.List;

public class Dec212024 {
    public int maxKDivisibleComponents(
            int n,
            int[][] edges,
            int[] values,
            int k
    ) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int[] result = new int[1];

        traverse(0, -1, graph, values, k, result);

        return result[0];
    }

    private int traverse(
            int current,
            int parent,
            List<Integer>[] graph,
            int[] nodeValues,
            int k,
            int[] result
    ) {
        int total = 0;

        for (int neighbor : graph[current]) {
            if (neighbor != parent) {
                total += traverse(
                        neighbor,
                        current,
                        graph,
                        nodeValues,
                        k,
                        result
                );
                total %= k;
            }
        }

        total += nodeValues[current];
        total %= k;

        if (total == 0) {
            result[0]++;
        }

        return total;
    }
}
