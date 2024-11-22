package org.example.nov2024;

import java.util.ArrayList;
import java.util.List;

public class Nov172024 {
    public class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" + "first=" + first + ", second=" + second + '}';
        }

        public U getValue() {
            return second;
        }
        public T getKey(){
            return first;
        }
    }
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        List<Pair<Long, Integer>> prefixSums = new ArrayList<>();
        prefixSums.add(new Pair<>(0L, -1));

        long sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            while (!prefixSums.isEmpty() && sum <= prefixSums.get(prefixSums.size() - 1).getKey()) {
                prefixSums.remove(prefixSums.size() - 1);
            }

            prefixSums.add(new Pair<>(sum, i));

            int idx = binarySearch(prefixSums, sum - k);
            if (idx != -1) {
                minLength = Math.min(minLength, i - prefixSums.get(idx).getValue());
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private int binarySearch(List<Pair<Long, Integer>> list, long target) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getKey() <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
