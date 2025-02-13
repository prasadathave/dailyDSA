package org.example.Feb2025;

import java.util.PriorityQueue;
import java.util.Queue;

public class Feb132025 {
    public int minOperations(int[] nums, int k) {
        Queue<Long> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer((long)num);
        }
        int op =0;
        while(pq.size()>1){
            long a = pq.poll();
            if(a>=k){
                return op;
            }
            long b = pq.poll();
            long c = Math.min(a,b)*2 + Math.max(a,b);

            pq.offer(c);
            op++;
        }
        if(pq.poll()>=k){
            return op;
        }
        return -1;
    }
}
