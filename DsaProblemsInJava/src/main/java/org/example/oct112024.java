package org.example;

import java.util.*;

public class oct112024 {
    private class Triplet{
        public int friendID;
        public int startTime;
        public int endTime;

        Triplet(int friendID,int startTime, int endTime){
            this.friendID = friendID;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean isTripletSuitable(Triplet triplet){
            if(triplet.startTime>=endTime){
                return true;
            }
            return triplet.endTime <= startTime;
        }
    }

    private class TripletComparatorByStartTIme implements Comparator<Triplet>{
        @Override
        public int compare(Triplet o1, Triplet o2) {
           return o1.startTime - o2.startTime;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        // Convert this into triplet list
        List<Triplet> listOfFriends = new ArrayList<>();
        for(int i =0; i< times.length; i++){
            listOfFriends.add(new Triplet(i,times[i][0],times[i][1]));
        }
        // sorting the new array by startTime
        Collections.sort(listOfFriends,new TripletComparatorByStartTIme());

        List<List<Triplet>> chairList = new ArrayList<>();
        // initializing the chairs
        for(int i=0; i<listOfFriends.size(); i++){
            chairList.add(new ArrayList<>());
        }
        // update the list
        for(int i=0; i<listOfFriends.size(); i++){
          int suitableChairIndex =  getSuitableChair(listOfFriends.get(i),chairList);
          if(listOfFriends.get(i).friendID==targetFriend){
              return suitableChairIndex;
          }
        }
        return listOfFriends.size();
    }

    private int getSuitableChair(Triplet triplet, List<List<Triplet>> chairList) {
        for(int chairIndex =0; chairIndex<chairList.size(); chairIndex++){
            boolean isSuitable= true;
            List<Triplet> currentChairList = chairList.get(chairIndex);
            for(int index=0; index<currentChairList.size(); index++){
                Triplet triplet1 = currentChairList.get(index);
                if(!triplet.isTripletSuitable(triplet1)){
                    isSuitable = false;
                }
            }
            if(isSuitable){
                currentChairList.add(triplet);
                return chairIndex;
            }
        }
        return chairList.size();
    }

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

    public int smallestChairOfGPT(int[][] times, int targetFriend) {
        // List to store events
        List<Event> events = new ArrayList<>();

        // Create events for arrival and departure
        for (int i = 0; i < times.length; i++) {
            events.add(new Event(times[i][0], i, true));  // arrival
            events.add(new Event(times[i][1], i, false)); // departure
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

        // Process the events
        for (Event event : events) {
            if (event.isArrival) {
                // Friend is arriving, get the smallest available chair
                int chair = availableChairs.poll();

                // If it's the target friend, return the chair number
                if (event.friendID == targetFriend) {
                    return chair;
                }

                // Mark this chair as occupied by this friend
                occupiedChairs.put(event.friendID, chair);


            } else {
                // Friend is leaving, free up their chair
                int chair = occupiedChairs.get(event.friendID);
                availableChairs.offer(chair);
            }
        }

        return -1; // This case should never happen as the target friend will always get a chair
    }





}
