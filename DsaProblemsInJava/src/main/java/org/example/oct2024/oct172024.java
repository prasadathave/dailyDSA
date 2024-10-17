package org.example.oct2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class oct172024 {
    public List<Integer> getListOfNumber(int num){
        List<Integer> numberList = new ArrayList<>();
        while(num!=0){
            int numToBeAdded = num%10;
            num = (num-numToBeAdded)/10;
            numberList.add(numToBeAdded);
        }
        return numberList;
    }

    public int constructNumberFromList(List<Integer> list){
        int multiplier = 1;
        int number = 0;
        for(int i =0; i<list.size(); i++){
            number += list.get(i)*multiplier;
            multiplier = multiplier*10;
        }
        return number;
    }

    public int maximumSwap(int num) {
        // create a list of integers in this list which will be 0-9
        List<Integer> numberInListForm = getListOfNumber(num);
        // create a copy of that list and sort it
        List<Integer> sortedList  = new ArrayList<>(numberInListForm);
        sortedList.sort(Comparator.comparingInt(a -> a));
        // Now start iterating from back and if two numbers are equal then continue
        for(int i=sortedList.size()-1; i>=0; i--){
            if(numberInListForm.get(i)!=sortedList.get(i)){
                int indexOfsortedNumber = numberInListForm.indexOf(sortedList.get(i));
                int currSortedNumber = sortedList.get(i);
                int currentNumberInUnSortedList = numberInListForm.get(i);
                numberInListForm.set(indexOfsortedNumber,currentNumberInUnSortedList);
                numberInListForm.set(i,currSortedNumber);
                break;
            }
        }
        // If they are no equal then this is where we need to swap
        // find the number in sorted list in unsorted list
        // swap the two in unsorted list
        // reconstruct the number in unsorted list
        // return this number
        return constructNumberFromList(numberInListForm);
    }
}
