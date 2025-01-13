package org.example.Jan012025;

public class Jan132025 {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        int val =0;
        for(int i=0; i<26; i++){
            if(freq[i]>=3){
                if(freq[i]%2==0){
                    val+=2;
                }
                else{
                    val+=1;
                }
            }
            else{
                val+=freq[i];
            }
        }
        return val;
    }
}
