package org.example.nov2024;

public class Nov262024 {
    public int findChampion(int n, int[][] edges) {
        int[] possibleAns = new int[n];
        for(int[]edge: edges){
            possibleAns[edge[1]] = -1;
        }

        int count = 0;
        int strongest = -1;
        int ind =0;
        for(int elem:possibleAns){

            if(elem!=-1){
                count++;
                strongest = ind;
            }
            ind++;
        }
        if(count==1){
            return strongest;
        }
        else{
            return -1;
        }
    }
}
