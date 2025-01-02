package org.example.Jan012025;

public class Jan022025 {
    private boolean isValid(String word){
        if(word.charAt(0)=='a'||word.charAt(0)=='e'||word.charAt(0)=='i'||word.charAt(0)=='o'||word.charAt(0)=='u'){
            int n = word.length()-1;
            return word.charAt(n) == 'a' || word.charAt(n) == 'e' || word.charAt(n) == 'i' || word.charAt(n) == 'o' || word.charAt(n) == 'u';
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int cntr =0;
        int[] validCntr = new int[words.length];
        for(int i=0; i<words.length; i++){
            if(isValid(words[i])){
                cntr++;
            }
            validCntr[i] = cntr;
        }
        //System.out.println("finalcntr - "+cntr);
        int[] answer = new int[queries.length];
        int index=0;
        for(int[] query: queries){
            int l = query[0];
            int r = query[1];
            //System.out.println("validCntr[r],validCntr[l]-"+validCntr[r]+","+validCntr[l]);
            answer[index] = validCntr[r]-validCntr[l];
            if(isValid(words[l])){
                answer[index]++;
            }
            index++;
        }
        return answer;
    }
}
