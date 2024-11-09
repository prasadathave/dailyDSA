package org.example.nov2024;


public class Nov092024 {

    public long minEnd(int n, int x) {
        long number = x;
        n--;
        while(n>0){
            n--;
            number = (number+1)|x;
        }
        return number;
    }

}
