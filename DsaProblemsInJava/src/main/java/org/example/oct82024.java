package org.example;

import java.util.Objects;
import java.util.Stack;

public class oct82024 {
    public int minSwaps(String s) {
        Stack<String> stk = new Stack<>();
        for(int i=0; i<s.length();i++){
            if(stk.isEmpty()){
                stk.push(s.substring(i,i+1));
            }
            else if(Objects.equals(stk.peek(), "[") && s.charAt(i) == ']'){
                stk.pop();
            }
            else {
                stk.push(s.substring(i,i+1));
            }
        }
        System.out.println("End stk size :- "+ stk.size());
        return (stk.size()/2+1)/2;
    }
}
