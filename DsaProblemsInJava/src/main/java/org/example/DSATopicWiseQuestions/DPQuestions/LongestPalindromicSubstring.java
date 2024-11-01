package org.example.DSATopicWiseQuestions.DPQuestions;

public class LongestPalindromicSubstring {

    private String getLongestPalindromeForParticularMid(int start, int end, String s){
        String runningStr = s.substring(start,end);
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            runningStr = s.substring(start,end);
            start--;
            end++;
        }
        return runningStr;
    }

    public String longestPalindrome(String s) {
        int strLen = s.length();
        String maxLenString ="";
        for(int i=0; i<s.length(); i++){

            String palEven = getLongestPalindromeForParticularMid(i,i+1,s);
            String palOdd = getLongestPalindromeForParticularMid(i,i,s);
            if(palOdd.length()>maxLenString.length()){
                maxLenString = palOdd;
            }
            if(palEven.length()>maxLenString.length()){
                maxLenString = palEven;
            }
        }
        return maxLenString;
    }

}
