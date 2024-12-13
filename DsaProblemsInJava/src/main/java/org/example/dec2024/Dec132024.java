package org.example.dec2024;

import java.util.PriorityQueue;

public class Dec132024 {
    private class triplet{
        public int index;
        public int number;
        triplet(int index,int number){
            this.index = index;
            this.number = number;
        }
    }

    public long findScore(int[] nums) {
        PriorityQueue<triplet> queue = new PriorityQueue<>((a, b)->{
            if(a.number-b.number!=0){
                return a.number-b.number;
            }
            else{
                return a.index - b.index;
            }
        });
        int index =0;
        for(int num:nums){
            queue.offer(new triplet(index,num));
            index++;
        }
        int[] marked = new int[nums.length];
        long sum = 0;
        while(!queue.isEmpty()){
            triplet tp = queue.poll();
            int number = tp.number;
            int ind = tp.index;
            if(marked[ind]!=1){
                sum+= number;
                marked[ind] = 1;
                if(ind-1>=0){
                    marked[ind-1] =1;
                }
                if(ind+1<nums.length){
                    marked[ind+1] = 1;
                }
            }
        }

        return sum;
    }
}
