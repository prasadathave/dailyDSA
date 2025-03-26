package org.example.march2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class March262025 {
    public int minOperations(int[][] grid, int x) {
        int rem = grid[0][0]%x;
        List<Integer> lst = new ArrayList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]%x!=rem){
                    return -1;
                }
                lst.add(grid[i][j]);
            }
        }

        Collections.sort(lst);
        int mid = lst.size()/2;
        int steps = 0;
        mid = lst.get(mid);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                steps += Math.abs(grid[i][j]-mid)/x;
            }
        }
        return steps;
    }
}
