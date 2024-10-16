package org.example.oct2024;


import java.util.PriorityQueue;



public class oct142024 {
    public long maxKelements(int[] nums,int k){
        long score = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> b-a);
        for(int num:nums){
            priorityQueue.offer(num);
        }
        int opsDone =0;
        while(opsDone!=k){
            Integer maxElem = priorityQueue.poll();
            score+= maxElem;
            double f1 = (double) maxElem;
            Integer result = (int) Math.ceil(f1/3);
            priorityQueue.offer(result);
            opsDone++;
        }
        return score;
    }
}
