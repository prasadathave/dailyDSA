package org.example.DSATopicWiseQuestions.SearchingSorting;

public class BoundariesInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right= nums.length-1;
        int mid = -1;
        int leftAnswer = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(mid>0 && nums[mid]==target && nums[mid-1]!=nums[mid]){
                leftAnswer = mid;
                break;
            }
            if(mid ==0 && nums[mid]==target){
                leftAnswer = mid;
                break;
            }

            if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }

        int rightAnswer = -1;
        left =0;
        right = nums.length -1;
        mid = -1;

        while(left<=right){
            mid = left + (right-left)/2;
            if(mid<nums.length-1 && nums[mid]==target && nums[mid+1]!=nums[mid]){
                rightAnswer = mid;
                break;
            }
            if(mid ==nums.length-1 && nums[mid]==target){
                rightAnswer = mid;
                break;
            }

            if(nums[mid]<=target){
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }

        int[] answer = new int[2];
        answer[0] = leftAnswer;
        answer[1] = rightAnswer;
        return answer;


    }
}
