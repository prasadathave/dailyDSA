package org.example.Jan012025;

public class Jan082025 {
    private boolean isPrefix(String s1, String s2){
        if(s1.length()<=s2.length()){
            for(int i=0; i<s1.length(); i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        else{
            // for(int i=0; i<s2.length(); i++){
            //     if(s1.charAt(i)!=s2.charAt(i)){
            //         return false;
            //     }
            // }
            // return true;
            return false;
        }
    }
    private boolean isSuffix(String s1, String s2){
        if(s1.length()<=s2.length()){
            for(int i= s2.length()-1; i>=0; i--){
                int s1Index = s1.length()- (s2.length()-i);
                if(s1Index<0){
                    break;
                }
                if(s1.charAt(s1Index)!=s2.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        else{
            // for(int i=s1.length()-1; i>=0; i--){
            //     int s2Index = s2.length()- (s1.length()-i);
            //     if(s2Index<0){
            //         break;
            //     }
            //     if(s1.charAt(i)!=s2.charAt(s2Index)){
            //         return false;
            //     }
            // }
            // return true;
            return false;
        }
    }
    public int countPrefixSuffixPairs(String[] words) {
        int counter =0;
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                boolean suff = isSuffix(words[i],words[j]);
                boolean pref =  isPrefix(words[i],words[j]);
                //System.out.println("suff,pref-"+suff+" , "+pref);
                if(suff && pref){
                    counter++;
                }
            }
        }

        return counter;
    }
}
