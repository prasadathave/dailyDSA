package org.example.Jan012025;

public class Jan112025 {
    public boolean canConstruct(String s, int k) {
        int[] charCounts = new int[26];
        for(int i=0; i<s.length(); i++){
            charCounts[s.charAt(i)-'a']++;
        }
        int evenSum =0;
        int oddSum =0;
        for(int i=0; i<26; i++){
            if(charCounts[i]%2==0 && charCounts[i]!=0){
                evenSum++;
            }
            else if(charCounts[i]%2==1){
                oddSum++;
            }
        }
        if(k>s.length()){
            return false;
        }
        //System.out.println("evenSum,oddSum-"+evenSum+","+oddSum);

        if(oddSum>k){
            return false;
        }

        return true;
    }
}
