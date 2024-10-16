package org.example.oct2024;

import java.util.*;

public class oct122024 {
    private class Event {
        public int time;
        public int friendID;
        public boolean isArrival;

        Event(int time, int friendID, boolean isArrival) {
            this.time = time;
            this.friendID = friendID;
            this.isArrival = isArrival;
        }
    }

    public int minGroups(int[][] times) {
        // List to store events
        List<oct122024.Event> events = new ArrayList<>();

        // Create events for arrival and departure
        for (int i = 0; i < times.length; i++) {
            events.add(new oct122024.Event(times[i][0], i, true));  // arrival
            events.add(new oct122024.Event(times[i][1], i, false)); // departure
        }

        // Sort events by time, and if the time is the same, prioritize departures over arrivals
        Collections.sort(events, (a, b) -> a.time == b.time ? Boolean.compare(a.isArrival, b.isArrival) : a.time - b.time);

        // Priority queue for available chairs (min-heap)
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        // Initialize chairs from 0 to n-1 (n is the number of friends)
        for (int i = 0; i < times.length; i++) {
            availableChairs.offer(i);
        }

        // Priority queue for occupied chairs, sorted by departure time
        Map<Integer, Integer> occupiedChairs = new HashMap<>(); // Maps friendID to chair number
        int maxChairs =0;
        // Process the events
        for (oct122024.Event event : events) {
            if (event.isArrival) {
                // Friend is arriving, get the smallest available chair
                int chair = availableChairs.poll();



                // Mark this chair as occupied by this friend
                occupiedChairs.put(event.friendID, chair);

                int currentChairs = times.length - occupiedChairs.size();
                if (currentChairs>maxChairs){
                    maxChairs = currentChairs;
                }


            } else {
                // Friend is leaving, free up their chair
                int chair = occupiedChairs.get(event.friendID);
                availableChairs.offer(chair);
            }
        }

        return maxChairs; // This case should never happen as the target friend will always get a chair
    }


    /// GPT solution
    public int minGroupsGPT(int[][] intervals) {
        // List to store start and end times as events
        List<int[]> events = new ArrayList<>();

        // Create events for start and end times
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});  // Start of an interval
            events.add(new int[]{interval[1] , -1}); // End of an interval (non-inclusive)
        }

        // Sort events by time, if times are equal, prioritize ending (-1) before starting (+1)
        Collections.sort(events, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int currentGroups = 0;
        int maxGroups = 0;

        // Process each event
        for (int[] event : events) {
            currentGroups += event[1]; // Add 1 for start, subtract 1 for end
            maxGroups = Math.max(maxGroups, currentGroups);
        }

        return maxGroups;
    }


}
