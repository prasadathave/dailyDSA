package org.example;

import java.util.Stack;

public class oct92024 {
    public int minAddToMakeValid(String s) {
        Stack<String> stk = new Stack<>();
        for(int i=0; i<s.length();i++){
            if(stk.isEmpty()){
                stk.push(s.substring(i,i+1));
            }
            else if(stk.peek().equals("(") && s.charAt(i)==')'){
                stk.pop();
            }
            else {
                stk.push(s.substring(i,i+1));
            }
        }
        return stk.size();
    }
}
