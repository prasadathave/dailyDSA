package org.example.Apr2025;

public class April112025 {
    private boolean isSym(int num){
        int num2 = num;
        int totalDigits =0;
        int totalSum =0;
        while(num!=0){
            totalSum += num%10;
            num = (num-num%10)/10;
            totalDigits+=1;
        }
        if(totalDigits%2!=0){
            return false;
        }
        int halfSum =0;
        for(int i=0; i<totalDigits/2; i++){
            halfSum += num2%10;
            num2 = num2/10;
        }
        // System.out.println(halfSum +","+totalSum);
        return halfSum*2==totalSum;
    }
    public int countSymmetricIntegers(int low, int high) {
        int symCnt =0;
        for(int i=low; i<=high; i++){
            boolean issym=isSym(i);
            if(issym){
                // System.out.println(i);
                symCnt++;
            }
        }
        return symCnt;
    }
}
