package org.example.Jan012025;

import java.util.*;

public class Jan312025 {
    private boolean isValid(int[][] grid, int[] pt){
        if(grid.length>pt[0] && grid[0].length>pt[1] && 0<=pt[0] && 0<=pt[1]){
            return true;
        }
        return false;
    }

    private void updateCount(int[][] grid, int[] pt, int[][] visited, int[] id , Map<Integer,Integer> mp){
        List<int[]> ptList = new ArrayList<>();

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(pt);

        int[][] nbs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] pl = q.poll();
            if(visited[pl[0]][pl[1]]!=1){
            ptList.add(pl);
            }
            visited[pl[0]][pl[1]] = 1;

            for(int[] nb:nbs){
                int[] npt = new int[]{pl[0]+nb[0], pl[1]+nb[1]};
                if(isValid(grid,npt) && visited[npt[0]][npt[1]]!=1 && grid[npt[0]][npt[1]]!=0){

                    q.offer(npt);
                }
            }
        }

        for(int[] p1 : ptList){
            grid[p1[0]][p1[1]] = id[0];
        }

        mp.put(id[0],ptList.size());

    }


    public int largestIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] nbs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int[] id = new int[1];
        id[0] = 1;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(visited[i][j]!=1 && grid[i][j]!=0){
                    updateCount(grid,new int[]{i,j},visited,id,mp);
                    id[0]+=1;
                }
            }
        }
        int maxScore  = -1;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int score =0;
                if(grid[i][j]==0){
                    HashSet<Integer> ids = new HashSet<>();
                    for(int[] nb:nbs){
                        if(isValid(grid,new int[]{nb[0]+i,nb[1]+j})){
                            ids.add(grid[nb[0]+i][nb[1]+j]);
                        }
                    }
                    for(int id1:ids){
                        score+= mp.get(id1);
                    }

                    score+=1;

                    if(score>maxScore){
                        maxScore = score;
                    }
                }
                else{

                    score += mp.get(grid[i][j]);
                    if(score>maxScore){
                        maxScore = score;
                    }
                }
            }
        }

        return maxScore;
    }
}
