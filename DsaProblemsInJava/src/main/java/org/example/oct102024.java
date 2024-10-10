package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class oct102024 {
    public int maxWidthRampBruteForce(int[] nums) {
        int maxRamp =0;
        for(int i=0; i<nums.length; i++){
            for(int j =i; j< nums.length; j++){
                if(nums[i]<=nums[j] && maxRamp<(j-i)){
                    maxRamp = j-i;
                }
            }
        }
        return maxRamp;
    }
    public int maxWidthRampSelfUpdated(int[] nums){
        int maxRamp =0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(list.isEmpty()){
                list.add(i);
            }
            else if (nums[list.get(list.size()-1)]>nums[i]){
                list.add(i);
            }
        }
        for(int i = nums.length-1; i>=0; i -= 1){
            if(maxRamp> i-list.get(0)){
                break;
            }
            int listIterator = list.size()-1;
            while(listIterator>=0){
                if(nums[list.get(listIterator)]<=nums[i] && maxRamp< i-list.get(listIterator)){
                    maxRamp = i-list.get(listIterator);
                }
                else if (nums[list.get(listIterator)]>nums[i]) {
                    break;
                }
                listIterator-=1;
            }
        }

        return maxRamp;
    }
    public int maxWidthRamp(int[] nums) {
        int maxRamp = 0;
        Stack<Integer> stack = new Stack<>();

        // First pass: store indices of a decreasing sequence in the stack
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        // Second pass: try to find the max width ramp
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxRamp = Math.max(maxRamp, i - stack.pop());
            }
        }

        return maxRamp;
    }


}
