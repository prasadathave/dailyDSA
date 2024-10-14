package org.example;

import java.util.*;

public class oct132024 {
    private class EntryInArr {
        public Integer number;
        public Integer groupId;

        EntryInArr(Integer number, Integer groupId){
            this.number = number;
            this.groupId = groupId;
        }
    }
    public int[] smallestRangeBruteForce(List<List<Integer>> nums) {
            // create an array of all entries with a class called entry
            List<EntryInArr> allEntries = new ArrayList<>();
            for(int i=0; i<nums.size(); i++){
                for(int j=0; j<nums.get(i).size(); j++){
                    allEntries.add(new EntryInArr(nums.get(i).get(j),i));
                }
            }
            // sort these entries
            Collections.sort(allEntries, new Comparator<EntryInArr>() {
                @Override
                public int compare(EntryInArr o1, EntryInArr o2) {
                    return o1.number-o2.number;
                }
            });
            // do this in n square by maintaining map and a counter for each iteration
            int minIntervalSize = 10000000;
            int finalIterationPoint = allEntries.size();
            int[] interval = new int[2];
            for(int startIndex=0; startIndex<=allEntries.size()- nums.size(); startIndex++){
                Map<Integer,Boolean> groupMarkerMap = new HashMap<>();
                int classCounter =0;

                int endIndex = startIndex;

                while(classCounter!= nums.size() && endIndex<finalIterationPoint){
                    groupMarkerMap.putIfAbsent(allEntries.get(endIndex).groupId, true);

                    classCounter = groupMarkerMap.size();
                    if(minIntervalSize<allEntries.get(endIndex).number-allEntries.get(startIndex).number && minIntervalSize!=10000000){
                        break;
                    }
                    if(classCounter == nums.size() && minIntervalSize>allEntries.get(endIndex).number-allEntries.get(startIndex).number){
                        minIntervalSize = allEntries.get(endIndex).number-allEntries.get(startIndex).number;
                        interval[0] = allEntries.get(startIndex).number;
                        interval[1] = allEntries.get(endIndex).number;
                        if(interval[1]-interval[0]==0){
                            return interval;
                        }
                    }
                    endIndex++;
                }

            }

            return interval;
    }


    /// GPT solution
    private class Entry {
        public int value;
        public int listIndex;
        public int elementIndex;

        Entry(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        int maxInRange = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        // Initialize the min-heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int firstElement = nums.get(i).get(0);
            minHeap.offer(new Entry(firstElement, i, 0));
            maxInRange = Math.max(maxInRange, firstElement);
        }

        // Continue until one of the lists is exhausted
        while (minHeap.size() == nums.size()) {
            Entry currentMin = minHeap.poll();
            int currentRangeStart = currentMin.value;
            int currentRangeEnd = maxInRange;

            // Update the smallest range if found
            if (currentRangeEnd - currentRangeStart < end - start) {
                start = currentRangeStart;
                end = currentRangeEnd;
            }

            // If the current list has more elements, add the next element to the heap
            if (currentMin.elementIndex + 1 < nums.get(currentMin.listIndex).size()) {
                int nextValue = nums.get(currentMin.listIndex).get(currentMin.elementIndex + 1);
                minHeap.offer(new Entry(nextValue, currentMin.listIndex, currentMin.elementIndex + 1));
                maxInRange = Math.max(maxInRange, nextValue);
            }
        }

        return new int[]{start, end};
    }



}
