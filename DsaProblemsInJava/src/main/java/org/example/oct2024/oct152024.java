package org.example.oct2024;

public class oct152024 {
    public long minimumSteps(String s) {
        int arr[] = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                arr[i] =1;
            }
            else{
                arr[i] =0;
            }
        }
        long swapCounter = 0;
        boolean swapped;
        for(int i=0; i< s.length()-1; i++){
            swapped = false;
            for(int j=0; j<s.length()-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int c = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = c;
                    swapCounter++;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return swapCounter;
    }
}
