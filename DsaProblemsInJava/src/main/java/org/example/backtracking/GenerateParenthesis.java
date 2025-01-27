package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private void generate(int n, int o, int c, String curr, List<String> list){
        if(n==o && o==c){
            list.add(curr);
            return;
        }
        if(o>n || c>n){
            return;
        }

        if(c == o){
            generate(n,o+1,c,curr+"(",list);
        }
        if(c<o){
            generate(n,o+1,c,curr+"(",list);
            generate(n,o,c+1,curr+")",list);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> s1 = new ArrayList<>();
        generate(n,0,0,"",s1);
        return s1;
    }
}
