package org.example.nov2024;

public class Nov182024 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] sumArr = new int[n];
        if(k>0){
            int initSum =0;
            for(int i=1; i<=k; i++){
                initSum+=code[i];
            }
            sumArr[0] = initSum;
            int currIndex = 1;
            int start=0;
            int end =0;
            while(currIndex<n){
                start = (currIndex+1)%n;
                end = (currIndex+k)%n;
                initSum -= code[currIndex];
                initSum+=code[end];
                sumArr[currIndex] = initSum;
                currIndex++;
            }
        }
        else if(k<0){
            k = -1*k;
            int initSum = 0;
            for(int i=n-k; i<n; i++){
                initSum+=code[i];
            }
            sumArr[0] = initSum;
            int currIndex =1;
            int start=0;
            int end =0;
            while(currIndex<n){
                end = currIndex -1;
                start = (end -k+n)%n;
                initSum -= code[start];
                initSum+= code[end];
                sumArr[currIndex] = initSum;
                currIndex++;
            }
        }
        return sumArr;
    }
}
