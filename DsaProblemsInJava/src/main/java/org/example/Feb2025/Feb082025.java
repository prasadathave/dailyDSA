package org.example.Feb2025;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Feb082025 {
    HashMap<Integer,Integer> indexToNumber;
    HashMap<Integer, SortedSet<Integer>> numberToIndexes;
    public Feb082025() {
        this.indexToNumber = new HashMap<>();
        this.numberToIndexes = new HashMap<>();
    }

    public void change(int index, int number) {
        if(this.indexToNumber.getOrDefault(index,null)!=null){
            int oldNumber = this.indexToNumber.get(index);
            numberToIndexes.get(oldNumber).remove(index);
        }

        indexToNumber.put(index,number);
        if(this.numberToIndexes.getOrDefault(number,null)==null){
            this.numberToIndexes.put(number,new TreeSet<>());
        }
        this.numberToIndexes.get(number).add(index);
    }

    public int find(int number) {

        if(this.numberToIndexes.getOrDefault(number,null)==null){
            return -1;
        }
        if(this.numberToIndexes.get(number).size()==0){
            return -1;
        }

        return this.numberToIndexes.get(number).first();
    }
}
