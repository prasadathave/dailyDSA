package org.example.Jan012025;

import java.util.HashMap;
import java.util.Map;

public class Jan232025 {
    public int countServers(int[][] grid) {
        Map<Integer,Integer> rowCount = new HashMap<>();
        Map<Integer,Integer> colCount = new HashMap<>();
        int totalCount =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    rowCount.put(i,rowCount.getOrDefault(i,0)+1);
                    colCount.put(j,colCount.getOrDefault(j,0)+1);
                    totalCount++;
                }
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    if(rowCount.get(i)==1 && colCount.get(j)==1){
                        totalCount--;
                    }
                }
            }
        }

        return totalCount;
    }
}
