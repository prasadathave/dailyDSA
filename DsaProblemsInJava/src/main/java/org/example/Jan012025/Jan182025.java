package org.example.Jan012025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Jan182025 {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});  // (cost, row, col)

        int[][] costMatrix = new int[rows][cols];
        for (int[] row : costMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        costMatrix[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int x = current[1];
            int y = current[2];

            if (costMatrix[x][y] != currentCost) {
                continue;
            }

            for (int direction = 0; direction < 4; direction++) {
                int dx = dirs[direction][0];
                int dy = dirs[direction][1];
                int nx = x + dx;
                int ny = y + dy;

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    int newCost = currentCost + (direction != (grid[x][y] - 1) ? 1 : 0);

                    if (costMatrix[nx][ny] > newCost) {
                        costMatrix[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }
        }

        return costMatrix[rows - 1][cols - 1];
    }
}
