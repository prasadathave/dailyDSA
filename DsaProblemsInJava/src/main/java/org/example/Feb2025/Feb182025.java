package org.example.Feb2025;

import java.util.ArrayList;
import java.util.List;

public class Feb182025 {
    private boolean generate(List<String> all,String pattern,String ans,int[] used){
        if(pattern.length()<ans.length()){
            all.add(ans);
            return true;
        }
        if(ans.length()==0){
            for(int i=0; i<9; i++){
                if(used[i+1]==1){
                    continue;
                }
                used[i+1] = 1;
                boolean output = generate(all,pattern,ans+(char)(i+'1'),used);
                used[i+1] =0;
                if(output){
                    return true;
                }
            }
        }
        else{
            char lastChar = pattern.charAt(ans.length()-1);
            int lastNum = (int)(ans.charAt(ans.length()-1) - '0');
            if(lastChar=='D'){
                for(int i=1; i<lastNum; i++){
                    if(used[i]==1){
                        continue;
                    }
                    used[i] = 1;
                    boolean output = generate(all,pattern,ans+(char)(i+'0'),used);
                    used[i] = 0;
                    if(output){
                        return true;
                    }
                }
            }
            else{
                for(int i=lastNum+1; i<=9;  i++){
                    if(used[i]==1){
                        continue;
                    }
                    used[i] = 1;
                    boolean output = generate(all,pattern,ans+(char)(i+'0'),used);
                    used[i] = 0;
                    if(output){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String smallestNumber(String pattern) {
        List<String> result = new ArrayList<>();
        int[] used = new int[10];
        boolean output = generate(result,pattern,"",used);
        if(output){
            return result.get(0);
        }
        return "";
    }
}
