package org.example.march2025;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class March272025 {
    private int[] findDominant(List<Integer> nums){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int maxval = nums.get(0);
        int maxcnt =mp.get(maxval);

        for(int num:mp.keySet()){
            if(mp.get(num)>maxcnt){
                maxval = num;
                maxcnt = mp.get(num);
            }
        }
        int[] ans = new int[2];
        ans[0] = maxval;
        ans[1] = maxcnt;
        return ans;
    }
    public int minimumIndex(List<Integer> nums) {
        int[] dom = findDominant(nums);
        int val = dom[0];
        int cnt = dom[1];
        int leftCnt = 0;
        for(int i=0; i<nums.size(); i++){
            if(nums.get(i)==val){
                leftCnt++;
            }
            int leftLen = i+1;
            int rightLen = nums.size() - leftLen;
            int rightCnt = cnt - leftCnt;
            if(leftLen/2<leftCnt && rightLen/2<rightCnt){
                return i;
            }
        }
        return -1;
    }
}
