package org.example.dec2024;

import java.util.PriorityQueue;

public class Dec162024 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[0]!=b[0]){
                return a[0] - b[0];
            }
            else {
                return a[1]-b[1];
            }
        });

        for(int i=0; i<nums.length; i++){
            int[] pair = new int[2];
            pair[0] = nums[i];
            pair[1] = i;
            pq.offer(pair);
        }

        while(k>0){
            int[] pair = pq.poll();
            nums[pair[1]] = nums[pair[1]]*multiplier;
            pair[0] = nums[pair[1]];
            pq.offer(pair);
            k--;
        }
        return nums;
    }
}
