package org.example.march2025;

public class March142025 {
    private boolean isPossible(int[] candies, long k, int val){
        if(val ==0){
            return true;
        }
        for(int elem:candies){
            k -= (int)(elem/val);
        }
        if(k<=0){
            return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        long max1 = 0;
        for(int elem:candies){
            max1 +=elem;
        }
        max1 = max1/k;
        int left = 0;
        int right = (int)max1;
        int ans = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(candies,k,mid)){
                left = mid +1;
                ans = mid;
            }
            else{
                right = mid -1;
            }
        }
        return ans;
    }
}
