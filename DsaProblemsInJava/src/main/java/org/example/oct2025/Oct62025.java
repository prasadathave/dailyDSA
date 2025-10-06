package org.example.oct2025;

import java.util.PriorityQueue;

public class Oct62025 {
    int[][] neighbours = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int getMinPath(int x, int y, int[][] grid, int[][] visited){
        if(x==grid.length -1 && y == grid.length-1){
            return grid[x][y];
        }
        visited[x][y] = 1;
        int currVal = grid[x][y];
        int minVal = Integer.MAX_VALUE;
        int[] minNeigh = new int[2];
        for(int[] nbh:neighbours ){
            int nx = nbh[0] +x;
            int ny = nbh[1] + y;
            if(nx>=grid.length || nx<0 || ny>=grid[0].length || ny<0){
                continue;
            }
            if(visited[nx][ny]==1){
                continue;
            }
            int val1 = getMinPath(nx,ny,grid,visited);
            if(minVal>val1){
                minVal = val1;
            }
        }

        visited[x][y] =0;

        return Math.max(currVal,minVal);
    }

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], time = cur[2];
            if (x == n - 1 && y == n - 1) return time;
            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{nx, ny, Math.max(time, grid[nx][ny])});
                }
            }
        }
        return -1;
    }
}
