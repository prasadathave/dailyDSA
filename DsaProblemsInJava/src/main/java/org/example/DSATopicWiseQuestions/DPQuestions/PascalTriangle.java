package org.example.DSATopicWiseQuestions.DPQuestions;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> globalList = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        if(numRows==0){
            return globalList;
        }
        firstList.add(1);
        globalList.add(firstList);
        if(numRows==1){
            return globalList;
        }
        List<Integer> copyOfFirstList = new ArrayList<>(firstList);
        copyOfFirstList.add(1);
        globalList.add(copyOfFirstList);
        if(numRows==2){
            return globalList;
        }
        for(int i=2; i<=numRows; i++){
            List<Integer> lastList = globalList.get(i-1);
            List<Integer> newList = new ArrayList<>();
            for(int j=1; j<lastList.size(); j++){
                newList.add(lastList.get(j-1)+lastList.get(j));
            }
            newList.add(0,1);
            newList.add(1);
            globalList.add(newList);
        }
        return globalList;
    }

}
