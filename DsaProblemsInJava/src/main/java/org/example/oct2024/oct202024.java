package org.example.oct2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class oct202024 {
    public List<Integer> getLevel1CommaList(String expression) {
        List<Integer> commaList = new ArrayList<>();
        Stack<Character> openingBracesStack = new Stack<>();
        for(int i=0; i<expression.length();i++){
            if(expression.charAt(i)=='('){
                openingBracesStack.push('(');
            }
            if(expression.charAt(i)==')'){
                openingBracesStack.pop();
            }
            if(expression.charAt(i)==',' && openingBracesStack.size()==1){
                commaList.add(i);
            }
        }

        return commaList;

    }

    public boolean parseBoolExpr(String expression) {
        // Find the first character
        char operation = expression.charAt(0);
        // Make segments of returning on the basis of that
        if (operation == 'f') {
            return false;
        } else if (operation == 't') {
            return true;
        } else if (operation == '!') {
            int length = expression.length();
            return !parseBoolExpr(expression.substring(2, length - 1));
        } else if (operation == '&') {
            List<Integer> commaList = getLevel1CommaList(expression);
            if(commaList.size()==0){
               return parseBoolExpr(expression.substring(2,expression.length()-1));
            }
            boolean result = true;
            for(int i=0;i<commaList.size(); i++){
                if(i==0){
                    result = result & parseBoolExpr(expression.substring(2,commaList.get(i)));
                }
                if(i== commaList.size()-1){
                    result = result & parseBoolExpr(expression.substring(commaList.get(i)+1,expression.length()-1));
                }
                if(i!=0){
                    result = result & parseBoolExpr(expression.substring(commaList.get(i-1)+1,commaList.get(i)));
                }
            }
            return result;

        } else if (operation == '|') {
            List<Integer> commaList = getLevel1CommaList(expression);
            if(commaList.size()==0){
               return parseBoolExpr(expression.substring(2,expression.length()-1));
            }
            boolean result = false;
            for(int i=0;i<commaList.size(); i++){
                if(i==0){
                    result = result | parseBoolExpr(expression.substring(2,commaList.get(i)));
                }
                if(i== commaList.size()-1){
                    result = result | parseBoolExpr(expression.substring(commaList.get(i)+1,expression.length()-1));
                }
                if(i!=0){
                    result = result | parseBoolExpr(expression.substring(commaList.get(i-1)+1,commaList.get(i)));
                }
            }
            return result;
        }
        return false;
    }
}
