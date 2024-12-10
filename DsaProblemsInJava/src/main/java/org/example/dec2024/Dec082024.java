package org.example.dec2024;

import org.example.nov2024.Nov172024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dec082024 {
    private class Pair<T>{
        T Key;
        T Value;

        public T getKey() {
            return Key;
        }

        public T getValue() {
            return Value;
        }
        Pair(T key, T Value){
            this.Key = key;
            this.Value = Value;
        }
    }
    public int maxTwoEvents(int[][] events) {
        // Create a PriorityQueue to store the pair of end time and value
        PriorityQueue<Pair<Integer>> eventQueue = new PriorityQueue<>(
                Comparator.comparingInt(Pair::getKey)
        );

        // Sort the events array in ascending order of start times
        Arrays.sort(events, (event1, event2) -> event1[0] - event2[0]);

        int highestValue = 0, totalMaxValue = 0;

        for (int[] currentEvent : events) {
            // Poll all valid events from the queue and take their maximum value
            while (!eventQueue.isEmpty() && eventQueue.peek().getKey() < currentEvent[0]) {
                highestValue = Math.max(highestValue, eventQueue.peek().getValue());
                eventQueue.poll();
            }

            totalMaxValue = Math.max(totalMaxValue, highestValue + currentEvent[2]);
            eventQueue.add(new Pair<Integer>(currentEvent[1], currentEvent[2]));
        }

        return totalMaxValue;
    }
}
