package org.example.nov2024;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Nov252024 {
    public int slidingPuzzle(int[][] board) {
        // Direction map for zero's possible moves in a 1D representation of the 2x3 board
        int[][] moveDirections = new int[][] {
                { 1, 3 },
                { 0, 2, 4 },
                { 1, 5 },
                { 0, 4 },
                { 1, 3, 5 },
                { 2, 4 },
        };

        String targetState = "123450";
        StringBuilder initialConfiguration = new StringBuilder();

        // Convert the 2D board into a string representation
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                initialConfiguration.append(board[row][col]);
            }
        }

        Set<String> seenConfigurations = new HashSet<>(); // To store visited states
        Queue<String> stateQueue = new LinkedList<>();
        stateQueue.add(initialConfiguration.toString());
        seenConfigurations.add(initialConfiguration.toString());

        int moveCount = 0;

        // BFS to find the minimum number of moves
        while (!stateQueue.isEmpty()) {
            int currentQueueSize = stateQueue.size();
            while (currentQueueSize-- > 0) {
                String currentConfiguration = stateQueue.poll();

                // Check if we reached the target solved state
                if (currentConfiguration.equals(targetState)) {
                    return moveCount;
                }

                int emptyTileIndex = currentConfiguration.indexOf('0');
                for (int nextTileIndex : moveDirections[emptyTileIndex]) {
                    String nextConfiguration = swapTiles(currentConfiguration, emptyTileIndex, nextTileIndex);

                    // Skip if this state has been visited
                    if (seenConfigurations.contains(nextConfiguration)) continue;

                    // Mark the new state as visited and add it to the queue
                    seenConfigurations.add(nextConfiguration);
                    stateQueue.add(nextConfiguration);
                }
            }
            moveCount++;
        }
        return -1;
    }

    // Helper method to swap characters at indices i and j in the string
    private String swapTiles(String configuration, int index1, int index2) {
        StringBuilder swappedConfiguration = new StringBuilder(configuration);
        swappedConfiguration.setCharAt(index1, configuration.charAt(index2));
        swappedConfiguration.setCharAt(index2, configuration.charAt(index1));
        return swappedConfiguration.toString();
    }
}
