package org.example.nov2024;

import java.util.PriorityQueue;

public class Nov292024 {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int numRows = grid.length, numCols = grid[0].length;
        int[][] movementDirections = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visitedCells = new boolean[numRows][numCols];

        PriorityQueue<int[]> timeQueue = new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0])
        );
        timeQueue.add(new int[] { grid[0][0], 0, 0 });

        while (!timeQueue.isEmpty()) {
            int[] currentCell = timeQueue.poll();
            int currentTime = currentCell[0], currentRow = currentCell[1], currentCol = currentCell[2];

            if (currentRow == numRows - 1 && currentCol == numCols - 1) {
                return currentTime;
            }

            if (visitedCells[currentRow][currentCol]) {
                continue;
            }
            visitedCells[currentRow][currentCol] = true;

            for (int[] direction : movementDirections) {
                int nextRow = currentRow + direction[0], nextCol = currentCol + direction[1];
                if (!isValid(visitedCells, nextRow, nextCol)) {
                    continue;
                }

                int waitTime = ((grid[nextRow][nextCol] - currentTime) % 2 == 0)
                        ? 1
                        : 0;
                int nextTime = Math.max(
                        grid[nextRow][nextCol] + waitTime,
                        currentTime + 1
                );
                timeQueue.add(new int[] { nextTime, nextRow, nextCol });
            }
        }
        return -1;
    }

    private boolean isValid(boolean[][] visitedCells, int row, int col) {
        return (
                row >= 0 &&
                        col >= 0 &&
                        row < visitedCells.length &&
                        col < visitedCells[0].length &&
                        !visitedCells[row][col]
        );
    }

}
