package org.example.Feb2025;

import java.util.HashSet;

public class Feb172025 {
    private void backtrack(String s1,int pt,HashSet<String> st,String currString){
        if(s1.length()==pt && currString.length()!=0){
            st.add(currString);
            return;
        }
        if(s1.length()==pt){
            return;
        }

        backtrack(s1,pt+1,st,currString);
        backtrack(s1,pt+1,st,currString+s1.charAt(pt));
    }

    private void generate(String tiles, String s1, int[] used, HashSet<String> st){
        if(s1.length()==tiles.length()){
            st.add(s1);
            return;
        }
        for(int i=0; i<tiles.length(); i++){
            if(used[i]!=1){
                used[i] = 1;
                st.add(s1+tiles.charAt(i));
                generate(tiles,s1+tiles.charAt(i),used,st);
                used[i] =0;
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        HashSet<String> st = new HashSet<>();
        generate(tiles,"",new int[tiles.length()],st);
        return st.size();
    }
}
