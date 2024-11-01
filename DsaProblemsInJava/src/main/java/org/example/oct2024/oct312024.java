package org.example.oct2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class oct312024 {
    // Does not work
//    private int getDistanceOfClosestFactoryAndFixRobot(int robotLocation,int[][] factory){
//        int minDist = Integer.MAX_VALUE;
//        int index = 0;
//        int finalIndex =-1;
//        for(int[] fact: factory){
//            int position = fact[0];
//            int limit = fact[1];
//            if(Math.abs(position-robotLocation)<minDist && limit>0){
//                minDist = Math.abs(position-robotLocation);
//                finalIndex = index;
//            }
//
//            index++;
//        }
//
//        if(finalIndex!=-1){
//            factory[finalIndex][1]--;
//            System.out.println("robotLocation-"+robotLocation+" minDist - "+minDist+" factoryLocation- "+factory[finalIndex][0]);
//
//            return minDist;
//        }
//        else {
//            return -1;
//        }
//    }
//    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
//        long totalMinDistance = 0L;
//
//        for(Integer robotLocation: robot){
//            int minDist = getDistanceOfClosestFactoryAndFixRobot(robotLocation,factory);
//            if(minDist==-1){
//                break;
//            }
//            totalMinDistance += minDist;
//        }
//
//        for(int[] fact: factory){
//            System.out.println(" factory - "+fact[0]+ " remaining limit- "+fact[1]);
//        }
//
//        return totalMinDistance;
//    }
//    // Working sol
//    public long minimumTotalDistanceGPT(List<Integer> robots, int[][] factories) {
//        // Sort robots and factories by position for easier access
//        robots.sort(Integer::compareTo);
//        Arrays.sort(factories, (a, b) -> Integer.compare(a[0], b[0]));
//
//        int n = robots.size();
//        int m = factories.length;
//        long[][] dp = new long[n + 1][m + 1];
//
//        // Initialize DP array with large values
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
//        }
//        dp[0][0] = 0;
//
//        // Iterate over robots and factories to fill the DP table
//        for (int i = 1; i <= n; i++) { // for each robot
//            for (int j = 1; j <= m; j++) { // for each factory
//                // Option 1: Do not assign this robot to factory j
//                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
//
//                // Option 2: Try assigning robot i to factory j and check distances
//                long distSum = 0;
//                for (int k = 1; k <= factories[j - 1][1] && i - k >= 0; k++) {
//                    distSum += Math.abs(robots.get(i - k) - factories[j - 1][0]);
//                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distSum);
//                }
//            }
//        }
//
//        return dp[n][m];
//    }

    public long getMinDistance(int currentRobo, int currentFactory, List<Integer> roboList,List<Integer> factoryPositions, long[][] memory){
        if(currentRobo==roboList.size()){
            return 0;
        }
        if(currentFactory==factoryPositions.size()){
            return Long.MAX_VALUE/10L;
        }
        if(memory[currentRobo][currentFactory]!=-1){
            return memory[currentRobo][currentFactory];
        }

        long assign = Math.abs(roboList.get(currentRobo)-factoryPositions.get(currentFactory))+getMinDistance(currentRobo+1,currentFactory+1,roboList,factoryPositions,memory);

        long doNotAssign = getMinDistance(currentRobo,currentFactory+1,roboList,factoryPositions,memory);
        memory[currentRobo][currentFactory] = Math.min(assign,doNotAssign);

        return memory[currentRobo][currentFactory];
    }

    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        // Sort robots and factories by position for easier access
        // Sort robots and factories by position for easier access
        robots.sort(Integer::compareTo);



        List<Integer> factoryPositions = new ArrayList<>();

        for(int[] factory:factories){
            for(int i=0; i<factory[1]; i++){
                factoryPositions.add(factory[0]);
            }
        }
        factoryPositions.sort(Integer::compareTo);
        int robotCount = robots.size();
        int factoryCount = factoryPositions.size();
        long[][] memo = new long[robotCount][factoryCount];
        for (long[] row : memo) Arrays.fill(row, -1);

        return getMinDistance(0,0,robots,factoryPositions,memo);

    }


}
