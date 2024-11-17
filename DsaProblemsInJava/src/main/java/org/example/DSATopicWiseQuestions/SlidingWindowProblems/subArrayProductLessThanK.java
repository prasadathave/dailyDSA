package org.example.DSATopicWiseQuestions.SlidingWindowProblems;

public class subArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int i = 0;
        int n = nums.length;
        int j = 0;
        int prod=1;
        int ans =0;

        while(j<n)
        {
            prod = prod*nums[j];

            while(prod>=k && i<=j)
            {
                prod/=nums[i];
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;

    }
}
