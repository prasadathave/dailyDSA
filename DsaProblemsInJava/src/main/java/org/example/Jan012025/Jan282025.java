package org.example.Jan012025;

import java.util.ArrayDeque;
import java.util.Queue;

public class Jan282025 {
    private boolean isValid(int[][] grid, int[] pt){
        int x = pt[0];
        int y = pt[1];
        int xl = grid.length;
        int yl = grid[0].length;
        if(x>=0 && x<xl && y>=0 && y<yl){
            return true;
        }
        return false;
    }

    public int dfs(int[][] grid, int[][] visited ,int[] pt){
        int[][] nbs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int sum = grid[pt[0]][pt[1]];
        visited[pt[0]][pt[1]] = 1;

        for(int[] nb: nbs){
            int[] npt = new int[]{pt[0]+nb[0],pt[1]+nb[1]};
            if(isValid(grid,npt) && visited[npt[0]][npt[1]]!=1 && grid[npt[0]][npt[1]]!=0){
                sum+= dfs(grid,visited,npt);
            }
        }
        return sum;
    }


    public int findMaxFish(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int[][] nbs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!=0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int maxSum = 0;
        while(!q.isEmpty()){
            int[] pt = q.poll();
            if(visited[pt[0]][pt[1]]!=1){
                int sum = dfs(grid,visited,pt);
                maxSum = Math.max(maxSum,sum);
            }

        }
        return maxSum;
    }
}
