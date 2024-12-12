package org.example.dec2024;

import java.util.PriorityQueue;

public class Dec122024 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{return b-a;});
        long valueInPile = 0;
        for(int gift:gifts){
            pq.offer(gift);

        }


        while(!pq.isEmpty() && k>0){
            int val = pq.poll();
            pq.offer(((int)Math.floor(Math.sqrt(val))));
            k--;
        }

        while(!pq.isEmpty()){
            int val = pq.poll();
            valueInPile += val;
        }

        return valueInPile;

    }
}
