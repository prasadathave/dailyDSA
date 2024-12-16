package org.example.dec2024;

import java.util.PriorityQueue;

public class Dec152024 {
    private class pair{
        public int pass;
        public int total;
        pair(int pass, int total){
            this.pass = pass;
            this.total = total;
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<pair> pairList = new PriorityQueue<>((a, b)->{
            double num1 = (double)(a.pass+1)/(a.total+1) - (double)(a.pass)/(a.total);
            double num2 = (double) (b.pass+1)/(b.total+1) - (double)(b.pass)/(b.total);
            if(num1<num2){
                return 1;
            }
            else if(num1==num2){
                return 0;
            }
            else{
                return -1;
            }
        });
        for(int[] cls:classes){
            pairList.offer(new pair(cls[0],cls[1]));
        }

        while(extraStudents>0){
            pair p = pairList.poll();
            //System.out.println("We chose -"+p.pass+","+p.total);
            p.pass+=1;
            p.total+=1;
            pairList.offer(p);
            extraStudents--;
        }
        double sum1 = 0;
        while(!pairList.isEmpty()){
            pair p = pairList.poll();
            sum1 += (double)p.pass/p.total;
        }
        return sum1/classes.length;
    }
}
