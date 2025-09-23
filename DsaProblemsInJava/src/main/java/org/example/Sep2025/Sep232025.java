package org.example.Sep2025;

import java.util.Arrays;

public class Sep232025 {
    private int compareFromIndex(String[] lst, int index){
        for(int i=index; i<lst.length; i++){
            int num = Integer.parseInt(lst[i]);
            if(num!=0){
                return 1;
            }
        }
        return 0;
    }
    public int compareVersion(String version1, String version2) {
        String[] v1Split = version1.split("\\.");
        String[] v2Split = version2.split("\\.");
        int minSize = Math.min(v1Split.length,v2Split.length);
        System.out.println(Arrays.toString(v1Split));
        System.out.println(Arrays.toString(v2Split));
        for(int i =0; i<minSize; i++){
            int num1 = Integer.parseInt(v1Split[i]);
            int num2 = Integer.parseInt(v2Split[i]);
            if(num1>num2){
                return 1;
            }
            else if(num1!=num2){
                return -1;
            }
        }
        if(minSize == v1Split.length){
            return -1 * compareFromIndex(v2Split,minSize);
        }
        else{
            return compareFromIndex(v1Split,minSize);
        }


    }

}
