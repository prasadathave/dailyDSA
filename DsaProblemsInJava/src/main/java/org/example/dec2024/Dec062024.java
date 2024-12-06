package org.example.dec2024;

import java.util.HashSet;
import java.util.Set;

public class Dec062024 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for(int ban:banned){
            bannedSet.add(ban);
        }
        int currSum =0;
        int numIntegers = 0;
        for(int i=1; i<=n; i++){
            if(currSum+i<=maxSum && !bannedSet.contains(i)){
                currSum = currSum+i;
                numIntegers++;
            }
        }

        return numIntegers;
    }
}
