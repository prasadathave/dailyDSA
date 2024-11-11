package org.example.nov2024;

public class Nov102024 {
    public int minimumSubarrayLengthBF(int[] nums, int k) {

        int minLength = nums.length+2;
        for(int starting_point=0; starting_point<nums.length;starting_point++){
            int[] orArr = new int[nums.length];
            orArr[starting_point] = nums[starting_point];
            for(int ending_point=starting_point; ending_point<nums.length; ending_point++){
              if(ending_point!=starting_point){
                  orArr[ending_point] = orArr[ending_point-1]|nums[ending_point];
              }
              if(orArr[ending_point]>=k && (ending_point-starting_point+1)<minLength){
                  minLength = ending_point-starting_point+1;
              }

            }
        }

        if (minLength==nums.length+2){
            return -1;
        }
        return minLength;
    }


    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int StartPoint = 0;
        int EndPoint = 0;
        int[] bitCountArr = new int[32]; // Tracks count of set bits at each position

        // Expand window until end of array
        while (EndPoint < nums.length) {
            // Add current number to window
            updateBitCounts(bitCountArr, nums[EndPoint], 1);

            // Contract window while OR value is valid
            while (
                    StartPoint <= EndPoint &&
                            getBitCountsToNumber(bitCountArr) >= k
            ) {
                // Update minimum length found so far
                minLength = Math.min(minLength, EndPoint - StartPoint + 1);

                // Remove leftmost number and shrink window
                updateBitCounts(bitCountArr, nums[StartPoint], -1);
                StartPoint++;
            }

            EndPoint++;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }


    private void updateBitCounts(int[] perBitCounts, int num, int addOrRemove) {
        for (int i = 0; i < 32; i++) {

            if (((num >> i) & 1) != 0) {
                perBitCounts[i] += addOrRemove;
            }
        }
    }

    // Converts bit count array back to number using OR operation
    private int getBitCountsToNumber(int[] bitCounts) {
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (bitCounts[bitPosition] != 0) {
                result |= 1 << bitPosition;
            }
        }
        return result;
    }


}
