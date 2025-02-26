package org.example.Feb2025;

import java.util.*;

public class Feb242025 {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        findBobPath(bob, 0);

        Arrays.fill(visited, false);
        findAlicePath(0, 0, 0, amount);

        return maxIncome;
    }

    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree;
    private int maxIncome = Integer.MIN_VALUE;

    private boolean findBobPath(int currentNode, int time) {
        bobPath.put(currentNode, time);
        visited[currentNode] = true;

        if (currentNode == 0) {
            return true;
        }

        for (int neighbor : tree.get(currentNode)) {
            if (!visited[neighbor] && findBobPath(neighbor, time + 1)) {
                return true;
            }
        }

        bobPath.remove(currentNode);
        return false;
    }

    private void findAlicePath(int currentNode, int time, int profit, int[] amount) {
        visited[currentNode] = true;

        if (!bobPath.containsKey(currentNode) || time < bobPath.get(currentNode)) {
            profit += amount[currentNode];
        } else if (time == bobPath.get(currentNode)) {
            profit += amount[currentNode] / 2;
        }

        if (tree.get(currentNode).size() == 1 && currentNode != 0) {
            maxIncome = Math.max(maxIncome, profit);
        }

        for (int neighbor : tree.get(currentNode)) {
            if (!visited[neighbor]) {
                findAlicePath(neighbor, time + 1, profit, amount);
            }
        }
    }
}
