package org.example.dec2024;

import org.example.nov2024.Nov172024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec222024 {
    public int[] leftmostBuildingQueries(int[] buildingHeights, int[][] queries) {
        List<Nov172024.Pair<Integer, Integer>> stack = new ArrayList<>();
        int[] results = new int[queries.length];
        Arrays.fill(results, -1);
        List<List<Nov172024.Pair<Integer, Integer>>> adjustedQueries = new ArrayList<>(buildingHeights.length);

        for (int i = 0; i < buildingHeights.length; i++) {
            adjustedQueries.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }
            if (buildingHeights[end] > buildingHeights[start] || start == end) {
                results[i] = end;
            } else {
                adjustedQueries.get(end).add(new Nov172024.Pair<>(buildingHeights[start], i));
            }
        }

        for (int i = buildingHeights.length - 1; i >= 0; i--) {
            int stackSize = stack.size();
            for (Nov172024.Pair<Integer, Integer> query : adjustedQueries.get(i)) {
                int position = findPosition(query.getKey(), stack);
                if (position < stackSize && position >= 0) {
                    results[query.getValue()] = stack
                            .get(position)
                            .getValue();
                }
            }

            while (
                    !stack.isEmpty() &&
                            stack.get(stack.size() - 1).getKey() <= buildingHeights[i]
            ) {
                stack.remove(stack.size() - 1);
            }

            stack.add(new Nov172024.Pair<>(buildingHeights[i], i));
        }

        return results;
    }

    private int findPosition(int height, List<Nov172024.Pair<Integer, Integer>> stack) {
        int left = 0;
        int right = stack.size() - 1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (stack.get(mid).getKey() > height) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

}
