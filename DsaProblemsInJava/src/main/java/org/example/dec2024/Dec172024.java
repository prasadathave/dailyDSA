package org.example.dec2024;

public class Dec172024 {
    private int getHighestAllowedCharacter(int[] countArr,int disAllowedChar){
        char dischar = (char) ('a'+disAllowedChar);
        for(int i=25; i>=0; i--){
            if(i!=disAllowedChar && countArr[i]>0){
                countArr[i]--;
                return i;
            }
        }
        return -1;
    }

    public String repeatLimitedString(String s, int repeatLimit) {

        int[] countArr = new int[26];
        for(int i=0; i<s.length(); i++){
            int ind = s.charAt(i) - 'a';
            countArr[ind]++;
        }

        StringBuilder sb = new StringBuilder();
        int num = getHighestAllowedCharacter(countArr,-1);
        int[] currCountMap = new int[26];
        if(num!=-1){
            sb.append((char)(num+'a'));
            currCountMap[num]++;
        }
        while(num !=-1){
            int leng = sb.length()-1;
            char currentChar = sb.charAt(leng);
            int limitLeft = repeatLimit-currCountMap[(int)(currentChar-'a')];

            if(limitLeft==0){
                num = getHighestAllowedCharacter(countArr,(int)currentChar-'a');
            }
            else{
                num = getHighestAllowedCharacter(countArr,-1);
            }
            if(num!=-1){
                sb.append((char)('a'+num));
                for(int i=0; i<26; i++){
                    if(num==i){
                        currCountMap[i]++;
                    }
                    else{
                        currCountMap[i] =0;
                    }
                }
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}
