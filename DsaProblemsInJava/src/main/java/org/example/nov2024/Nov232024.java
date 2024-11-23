package org.example.nov2024;

public class Nov232024 {
    public char[][] rotateTheBox(char[][] box) {
        int numRows = box.length;
        int numColumns = box[0].length;

        char[][] resultArr = new char[numColumns][numRows];
        for(int rowNumber =0; rowNumber<numRows; rowNumber++){
            char[] corrRow = box[rowNumber];
            int index =0;
            int hashCounter =0;
            for(char c1 : corrRow){
                if(c1=='*'){
                    int currInd = index-1;
                    while(hashCounter>0){
                        corrRow[currInd] = '#';
                        currInd--;
                        hashCounter--;
                    }
                }
                if(c1=='#'){
                    hashCounter++;
                    corrRow[index] = '.';
                }
                index++;
            }
            index = index-1;
            while(hashCounter>0){
                corrRow[index] = '#';
                hashCounter--;
                index--;
            }
        }
        for(int i=0; i<numColumns; i++){
            for(int j=0; j<numRows; j++){
                resultArr[i][j] = box[numRows-1-j][i];
            }
        }
        return resultArr;
    }
}
