package org.example.RandomQuestions;

import java.util.*;

public class Interview {

    private int distAB(char[][] grid,int[] p1, int[] p2){
        if(grid==null || p1==null || p2==null){
            return Integer.MAX_VALUE;
        }
        int p1x = p1[0];
        int p1y = p1[1];
        int p2x = p2[0];
        int p2y = p2[1];
        int[][] distances = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] visited = new int[grid.length][grid[0].length];
        distances[p1x][p1y] = 0;
        Queue<int[]> points = new ArrayDeque<>();
        points.add(p1);
        while(!points.isEmpty()){
            int[] pt = points.poll();
            visited[pt[0]][pt[1]] =1;
            List<int[]> ptsToUpdateVal = new ArrayList<>();
            if(pt[0]-1>=0){
                if(visited[pt[0]-1][pt[1]]!=1) {
                    points.add(new int[]{pt[0] - 1, pt[1]});
                    ptsToUpdateVal.add(new int[]{pt[0] - 1, pt[1]});
                }
            }
            if(pt[0]+1< grid.length){
                if(visited[pt[0]+1][pt[1]]!=1) {
                    points.add(new int[]{pt[0] + 1, pt[1]});
                    ptsToUpdateVal.add(new int[]{pt[0] + 1, pt[1]});
                }
            }

            if(pt[1]-1>=0){
                if(visited[pt[0]][pt[1]-1]!=1) {
                    points.add(new int[]{pt[0], pt[1] - 1});
                    ptsToUpdateVal.add(new int[]{pt[0], pt[1] - 1});
                }
            }
            if(pt[1]+1< grid[0].length){
                if(visited[pt[0]][pt[1]+1]!=1) {
                    points.add(new int[]{pt[0], pt[1] + 1});
                    ptsToUpdateVal.add(new int[]{pt[0], pt[1] + 1});
                }
            }

            for(int[] pt1: ptsToUpdateVal){
                if(grid[pt1[0]][pt1[1]]!='#') {
                    distances[pt1[0]][pt1[1]] = Math.min(distances[pt1[0]][pt1[1]], distances[pt[0]][pt[1]]+1);
                }
            }
        }
        return distances[p2x][p2y];
    }
    public int findMinSteps(char[][] grid, List<Character> ordersList){
        // locations of these orders
        if(ordersList.isEmpty()){
            return 0;
        }
        Map<Character,int[]> pairMap = new HashMap<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!='.'||grid[i][j]!='#'){
                    pairMap.put(grid[i][j],new int[]{i,j});
                }
            }
        }

        // distances from one order to other
        int distanceTotal = 0;
        for(int i=0; i<ordersList.size(); i++){
            if(i==0){
                int currDist =distAB(grid,new int[]{0,0},pairMap.get(ordersList.get(i)));
                if (currDist==Integer.MAX_VALUE){
                    return -1;
                }
                distanceTotal+=currDist;
            }
            else{
                int currDist = distAB(grid,pairMap.getOrDefault(ordersList.get(i-1),null), pairMap.getOrDefault(ordersList.get(i),null));
                if(currDist==Integer.MAX_VALUE){
                    return -1;
                }
                distanceTotal+=currDist;
            }
        }

        int currDist = distAB(grid,pairMap.getOrDefault(ordersList.get(ordersList.size()-1),null),new int[]{0,0});
        distanceTotal+=currDist;
        return distanceTotal;
    }
}
