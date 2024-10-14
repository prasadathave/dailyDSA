package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
//        System.out.println(new oct82024().minSwaps("][]["));
//        System.out.println(new oct82024().minSwaps("]]][[["));
//        System.out.println(new oct82024().minSwaps("[]"));
//        System.out.println(new oct92024().minAddToMakeValid("())"));
//        System.out.println(new oct92024().minAddToMakeValid("))((("));
//
//        System.out.println(new oct102024().maxWidthRampBruteForce(new int[]{6,0,8,2,1,5}));
//        System.out.println(new oct102024().maxWidthRampBruteForce(new int[]{9,8,1,0,1,9,4,0,4,1}));
//        System.out.println(new oct102024().maxWidthRamp(new int[]{6,0,8,2,1,5}));
//        System.out.println(new oct102024().maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
//        System.out.println(new oct102024().maxWidthRamp(new int[]{}));
//        System.out.println(new oct102024().maxWidthRampBruteForce(new int []{}));
//        System.out.println(new oct102024().maxWidthRampSelfUpdated(new int []{}));
        int [][] arr2d = new int[][]{{1,4},{2,3},{4,6}};
        int [][] arr2d2 = new int[][]{{3,10},{1,5},{2,6}};

        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();

        Collections.addAll(l1, 4,10,15,24,26);
        Collections.addAll(l2,0,9,12,20);
        Collections.addAll(l3,5,18,22,30);
        nums.add(l1);
        nums.add(l2);
        nums.add(l3);
//        System.out.println(new oct112024().smallestChair(arr2d,1));
//        System.out.println(new oct112024().smallestChair(arr2d2,0));
//
//        System.out.println(new oct122024().minGroupsGPT(new int[][]{{1,5},{5,7}}));
        System.out.println(Arrays.toString(new oct132024().smallestRangeBruteForce(nums)));
    }
}