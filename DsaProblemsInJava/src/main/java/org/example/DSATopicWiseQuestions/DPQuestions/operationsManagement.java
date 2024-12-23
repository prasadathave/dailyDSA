package org.example.DSATopicWiseQuestions.DPQuestions;

public class operationsManagement {
    private int findMinSum(int[] nums, int currentIndex, int k, int op1, int op2, int sum){
//        System.out.println(sum+" op1-"+op1+" op2-"+op2+" currIndex-"+currentIndex);
        if(currentIndex==nums.length || (op1==0&&op2==0) ){
            return sum;
        }
        int sum1 = sum;
        int sum2 = sum;
        int sum3 = sum;
        int sum4 = sum;
        int origSum = sum;
        // Doing op1 alone
        if(op1>0){
            sum1 = Math.min(sum,findMinSum(nums,currentIndex+1,k,op1-1,op2,sum-nums[currentIndex] + (int)Math.round((float)nums[currentIndex]/2)));
        }
        if(op2>0 && nums[currentIndex]>=k){
            // Doing both
            if(op1>0){
                sum2 = Math.min(sum,findMinSum(nums,currentIndex+1,k,op1-1,op2-1,sum-nums[currentIndex] + (int)Math.round((float)nums[currentIndex]/2)-k));
            }
            // op2 alone
            sum3 = Math.min(origSum,findMinSum(nums,currentIndex+1,k,op1,op2-1,sum-k));
        }
        // Doing None
        sum4 = Math.min(sum,findMinSum(nums,currentIndex+1,k,op1,op2,sum));
        return Math.min(Math.min(sum1,sum2),Math.min(sum3,sum4));
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int sum =0;
        for(int num:nums){
            sum+=num;
        }

        return findMinSum(nums,0,k,op1,op2,sum);
    }
}
