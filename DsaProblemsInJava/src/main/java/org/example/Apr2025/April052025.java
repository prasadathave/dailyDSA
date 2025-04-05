package org.example.Apr2025;

import java.util.ArrayList;
import java.util.List;

public class April052025 {
    private int getAnswer(int[] nums, List<Integer> lst, int index){
        if(index>=nums.length){
            if(lst.size()==0){
                return 0;
            }
            int xor =lst.get(0);
            for(int i=1; i<lst.size(); i++){
                xor = xor ^ lst.get(i);
            }
            return xor;
        }
        lst.add(nums[index]);
        int s1 = getAnswer(nums,lst,index+1);
        lst.remove((Integer)nums[index]);
        int s2 = getAnswer(nums,lst,index+1);
        return s1+s2;
    }
    public int subsetXORSum(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        return getAnswer(nums,lst,0);
    }
}
