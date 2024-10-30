package org.example.oct2024;

public class oct292024 {
    private int getMaxMoves(int[][] grid, int[][] maxMovesGrid, int rowNumber,int columnNumber){
        if(rowNumber>=grid.length){
            return 0;
        }
        if(columnNumber>=grid[0].length-1){
            return 0;
        }
        if(maxMovesGrid[rowNumber][columnNumber]!=0){
            return maxMovesGrid[rowNumber][columnNumber];
        }
        // Calculate max by taking case 1,2,3
        int case1 =0;
        int case2 =0;
        int case3 =0;

        if(rowNumber-1>=0 && columnNumber+1<=grid[0].length-1 && grid[rowNumber][columnNumber]<grid[rowNumber-1][columnNumber+1]){
            case1 = 1+ getMaxMoves(grid,maxMovesGrid,rowNumber-1,columnNumber+1);
        }
        if(rowNumber>=0 && columnNumber+1<=grid[0].length-1 && grid[rowNumber][columnNumber]<grid[rowNumber][columnNumber+1]){
            case2 = 1+ getMaxMoves(grid,maxMovesGrid,rowNumber,columnNumber+1);
        }
        if(rowNumber+1< grid.length && columnNumber+1<=grid[0].length-1 && grid[rowNumber][columnNumber]<grid[rowNumber+1][columnNumber+1]){
            case3 = 1+ getMaxMoves(grid,maxMovesGrid,rowNumber+1,columnNumber+1);
        }

        maxMovesGrid[rowNumber][columnNumber] = Math.max(case1,Math.max(case2,case3));
        System.out.println("for rownumber , columnNumber- "+ rowNumber+ " "+columnNumber+ " value is -");
        return maxMovesGrid[rowNumber][columnNumber];
    }

    public int maxMoves(int[][] grid) {
        int numRows = grid.length;
        int numColumns = grid[0].length;
        int maxMoves =0;
        int[][] maxMovesGrid = new int[numRows][numColumns];
        for(int i=0; i<numRows;i++){
            int rowNumber = i;
            int colNumber = 0;
            maxMoves = Math.max(getMaxMoves(grid,maxMovesGrid,rowNumber,colNumber),maxMoves);
        }

        return maxMoves;
    }
}
