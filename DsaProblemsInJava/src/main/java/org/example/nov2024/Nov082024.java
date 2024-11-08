package org.example.nov2024;

public class Nov082024 {
        private int getMaxXORNumberLessThanABit(int number, int maximumBit){
            int bitNumber =0;
            int maxNumber =0;

            while(bitNumber<maximumBit){
                int currBit = number%2;
                int maxBit = 1-currBit;
                maxNumber += Math.pow(2,bitNumber)*maxBit;
                bitNumber++;
                number = (number - number%2)/2;
            }

            return maxNumber;
        }

        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int[] answers = new int[nums.length];
            int lastXor = nums[0];
            for(int i= nums.length-1; i>=0; i--){
                int currIndex = nums.length-1-i;
                if(currIndex==0){
                    lastXor = nums[0];
                }
                else{
                    lastXor = lastXor^nums[currIndex];
                }
                answers[i] = getMaxXORNumberLessThanABit(lastXor,maximumBit);
            }
            return answers;
        }

}
