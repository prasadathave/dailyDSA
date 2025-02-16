package org.example.Feb2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Feb162025 {
    private void generateAnswer(List<Integer> currList, int remaining, List<List<Integer>> allSeq, int[] lastIndex, int[] countMap){
        if(remaining==0){
            allSeq.add(new ArrayList<>(currList));
            return;
        }

        for(int i= countMap.length-1; i>=1; i--){
            int ind = currList.size();
            int li = lastIndex[i];
            int cnt = countMap[i];
            if(li!=-1 && cnt>0 && (ind-li)==i){
                lastIndex[i] = ind;
                countMap[i] = cnt-1;
                currList.add(i);
                generateAnswer(currList,remaining-1,allSeq,lastIndex,countMap);
                lastIndex[i] = li;
                countMap[i] = cnt;
                currList.remove(ind);
            }
            else if(li ==-1){
                lastIndex[i] = ind;
                countMap[i] = cnt-1;
                currList.add(i);
                generateAnswer(currList,remaining-1,allSeq,lastIndex,countMap);
                lastIndex[i] = li;
                countMap[i] = cnt;
                currList.remove(ind);
            }
        }
    }

    private List<Integer> getMax(List<Integer> l1, List<Integer> l2){
        int i1 =0;
        int i2 =0;
        if(l1.size()>l2.size()){
            return l1;
        }
        else if(l2.size()>l1.size()){
            return l2;
        }

        while(i1<l1.size() && i2<l2.size()){
            if(l1.get(i1)>l2.get(i2)){
                return l1;
            }
            if(l1.get(i1)<l2.get(i2)){
                return l2;
            }
            i1++;
            i2++;
        }


        return l1;
    }

    public int[] constructDistancedSequence(int n) {
        List<Integer> currList = new ArrayList<>();
        int remaining = 2*n-1;
        List<List<Integer>> results = new ArrayList<>();
        int[] lastIndex = new int[n+1];
        Arrays.fill(lastIndex,-1);
        int[] countMap = new int[n+1];

        countMap[1] = 1;
        for(int i=2; i<=n; i++){
            countMap[i] = 2;
        }
        generateAnswer(currList,remaining,results,lastIndex,countMap);
        List<Integer> maxList = results.get(0);
        for(int i=1; i<results.size(); i++){
            maxList = getMax(maxList,results.get(i));
        }

        int[] output = new int[maxList.size()];
        for(int i=0; i<maxList.size(); i++){
            output[i] = maxList.get(i);
        }
        return output;
    }
}
