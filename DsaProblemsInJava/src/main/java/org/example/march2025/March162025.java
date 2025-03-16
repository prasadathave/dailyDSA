package org.example.march2025;

public class March162025 {
    public boolean isPerfectSquare(long n) {
        long i = 1;
        while (n > 0) {
            n -= i;
            i += 2L;
        }
        return n == 0L;
    }
    private boolean isGood(int[] ranks, long value, int cars){
        // boolean perfectSquareFound = false;
        // for(int rnk:ranks){
        //     if(value%rnk==0){
        //         if(isPerfectSquare(value/rnk)){
        //             perfectSquareFound = true;
        //             break;
        //         }
        //     }
        // }
        // if(!perfectSquareFound){
        //     return false;
        // }
        long maxPossibleCars = 0;
        for(int rnk:ranks){
            long forThisRank = (long)Math.floor(Math.sqrt(value/(long)rnk));
            maxPossibleCars+=forThisRank;
        }
        if(maxPossibleCars>=cars){
            return true;
        }
        return false;
    }


    public long repairCars(int[] ranks, int cars) {
        int maxrank = ranks[0];
        for(int rnk : ranks){
            if(rnk>maxrank){
                maxrank = rnk;
            }
        }
        int minrank = ranks[0];
        for(int rnk:ranks){
            if(rnk<minrank){
                minrank = rnk;
            }
        }

        long left = 1;
        long right = (long)minrank * (long)cars * (long)cars;
        long answer = right;
        while(left<right){
            long mid = (left+right)/2;
            if(isGood(ranks,mid,cars)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }
}
