package org.example.dec2024;

import java.util.Stack;

public class Dec052024 {
    /**
     * You can do it with 2 pointer or adding pairs to stack as well
     * @param start
     * @param target
     * @return
     */
    public boolean canChange(String start, String target) {
        Stack<Integer> LIndexStart = new Stack<>();
        Stack<Integer> RIndexStart = new Stack<>();

        Stack<Integer> LIndexTarget = new Stack<>();
        Stack<Integer> RIndexTarget = new Stack<>();

        StringBuilder ExtractedStart = new StringBuilder();
        StringBuilder ExtractedTarget = new StringBuilder();

        for(int i=0; i<start.length(); i++){
            if(start.charAt(i)!='_'){ExtractedStart.append(start.charAt(i));}
            if(target.charAt(i)!='_'){ExtractedTarget.append(target.charAt(i));}


            if(start.charAt(i)=='L'){
                LIndexStart.push(i);
            }
            if(start.charAt(i)=='R'){
                RIndexStart.push(i);
            }
            if(target.charAt(i)=='L'){
                LIndexTarget.push(i);
            }
            if(target.charAt(i)=='R'){
                RIndexTarget.push(i);
            }
        }

        if(!ExtractedStart.toString().equals(ExtractedTarget.toString())){
            System.out.println(ExtractedStart);
            System.out.println(ExtractedTarget);
            return false;
        }
        if(RIndexTarget.size()!=RIndexStart.size() || LIndexTarget.size()!=LIndexStart.size()){
            return false;
        }
        while(!RIndexTarget.isEmpty()){
            int RStart = RIndexStart.pop();
            int RTarget = RIndexTarget.pop();
            if(RStart>RTarget){
                //System.out.println("Rstart, RTarget"+RStart+" "+RTarget);
                return false;
            }
        }

        while(!LIndexTarget.isEmpty()){
            int LStart = LIndexStart.pop();
            int LTarget = LIndexTarget.pop();
            if(LStart < LTarget){
                //System.out.println("LStart, LTarget"+LStart+" "+LTarget);
                return false;
            }
        }

        return true;
    }
}
