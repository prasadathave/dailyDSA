package org.example.oct2025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Oct052025 {
    int[][] neighbours = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private boolean isValid(int x, int y, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(x<m && x>=0 && y<n && y>=0){
            return true;
        }
        return false;
    }


    private int[][] getVisitables(int ox, int oy , int[][] heights, int ocean){
        // Checks if it is accessible from a particular ocean
        // ocean = 1 is pacific and ocean = 2 is atlantic
        int m = heights.length;
        int n = heights[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{ox,oy});


        while(!q.isEmpty()){
            int[] pt = q.poll();
            visited[pt[0]][pt[1]] = 1;
            for(int[] nbh: neighbours){
                int nx = pt[0]+nbh[0];
                int ny = pt[1]+nbh[1];
                if(isValid(nx,ny,heights) && visited[nx][ny]!=1){
                    int hNew = heights[nx][ny];
                    int hOld = heights[pt[0]][pt[1]];
                    if(hNew<=hOld){
                        q.offer(new int[]{nx,ny});
                    }
                    else if(ocean ==1 && (nx==0 || ny==0)){
                        q.offer(new int[]{nx,ny});
                    }
                    else if(ocean ==2 && (nx==m-1 || ny == n-1)){
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return visited;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] v1 = getVisitables(0,0,heights,1);
        int[][] v2 = getVisitables(heights.length-1,heights[0].length-1,heights,2);

        List<List<Integer>> lst = new ArrayList<>();

        for(int i=0; i<heights.length; i++){
            for(int j =0; j<heights[0].length; j++){
                if(v1[i][j]!=0 && v2[i][j]!=0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    lst.add(ans);
                }
            }
        }
        return lst;
    }
}
