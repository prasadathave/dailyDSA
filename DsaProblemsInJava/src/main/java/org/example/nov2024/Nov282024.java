package org.example.nov2024;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Nov282024 {
    private class Node {
        public int rowNum;
        public int colNum;

        Node(int x, int y) {
            this.rowNum = x;
            this.colNum = y;
        }
    }

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = grid[0][0];

        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node nd = queue.poll();

            List<Node> nodesToBeChecked = new ArrayList<>();
            if (nd.rowNum + 1 < m) {
                nodesToBeChecked.add(new Node(nd.rowNum + 1, nd.colNum));
            }
            if (nd.rowNum > 0) {
                nodesToBeChecked.add(new Node(nd.rowNum - 1, nd.colNum));
            }
            if (nd.colNum + 1 < n) {
                nodesToBeChecked.add(new Node(nd.rowNum, nd.colNum + 1));
            }
            if (nd.colNum > 0) {
                nodesToBeChecked.add(new Node(nd.rowNum, nd.colNum - 1));
            }

            for (Node n1 : nodesToBeChecked) {
                if (distance[n1.rowNum][n1.colNum] > distance[nd.rowNum][nd.colNum] + grid[n1.rowNum][n1.colNum]) {
                    distance[n1.rowNum][n1.colNum] = distance[nd.rowNum][nd.colNum] + grid[n1.rowNum][n1.colNum];
                    queue.offer(n1);
                }
            }
        }


        return distance[m - 1][n - 1];
    }
}
