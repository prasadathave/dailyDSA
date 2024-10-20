package org.example.oct2024;

public class oct192024 {
    public static int findHighestOneBitPosition(long num) {
        int position = -1;  // To store the position of the highest set bit
        for (int i = 0; i < 64; i++) {
            if ((num & (1L << i)) != 0) {
                position = i;
            }
        }
        return position;
    }


    private long getReversedBinary(long num) {
        int highestBitPosition = findHighestOneBitPosition(num);
        if (highestBitPosition == -1) {
            return 0;  // If no bits are set, return 0
        }

        long reversedNum = 0;
        for (int i = 0; i <= highestBitPosition; i++) {
            // Get the i-th bit from num
            long bit = (num >> i) & 1;
            // Place it at the reversed position
            reversedNum |= (bit << (highestBitPosition - i));
        }
        return reversedNum;
    }
    private int getBinaryLength(long num){
        return Long.toBinaryString(num).length();
    }
    private long getInvertedBits(long num){
        int length = getBinaryLength(num);
        long mask = (1<<length)-1;
        return mask^num;
    }
    private long getConstantTobeAdded(long lastNumberInArray){
        int binaryLength = getBinaryLength(lastNumberInArray);
        long number = (1L <<(binaryLength+1));
        return number;
    }

    public char findKthBit(int n, int k) {
        long[] arr = new long[n+1];
        arr[0] =0;
        for(int i=1; i<=n; i++){
            int binaryLength = getBinaryLength(arr[i-1])+2;
            long multiplier = (long) Math.pow(2,binaryLength);
            arr[i] =  arr[i-1]*multiplier + getReversedBinary(getInvertedBits(arr[i-1])) + getConstantTobeAdded(arr[i-1]);
            System.out.println(arr[i]);
        }
        return Long.toBinaryString(arr[n]).charAt(k);
    }
    ////////////////////
    public char findKthBitGPT(int n, int k) {
        return findKthBitHelper(n, k);
    }

    private char findKthBitHelper(int n, int k) {
        // Base case: if n == 1, S1 is "0", so the only bit is '0'
        if (n == 1) {
            return '0';
        }

        // Length of Sn is 2^n - 1
        int length = (1 << n) - 1;  // (1 << n) is the same as 2^n

        int middle = length / 2 + 1;  // Middle index (1-based indexing)

        if (k == middle) {
            // Middle bit is always '1'
            return '1';
        } else if (k < middle) {
            // If k is in the first half, it's the same as in Sn-1
            return findKthBitHelper(n - 1, k);
        } else {
            // If k is in the second half, mirror it to the first half and invert it
            int mirroredIndex = length - k + 1;  // Find the mirrored position
            char mirroredBit = findKthBitHelper(n - 1, mirroredIndex);
            // Invert the mirrored bit ('0' becomes '1', and '1' becomes '0')
            return mirroredBit == '0' ? '1' : '0';
        }
    }













}
