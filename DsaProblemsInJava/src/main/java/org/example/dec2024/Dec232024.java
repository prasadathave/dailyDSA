package org.example.dec2024;

import org.example.oct2024.oct222024;

import java.util.*;

public class Dec232024 {
    public int minimumOperations(oct222024.TreeNode root) {
        Queue<oct222024.TreeNode> treeQueue = new ArrayDeque<>();
        treeQueue.offer(root);
        int opCounter =0;
        // int levelCounter =0;
        while(!treeQueue.isEmpty()){
            // int currentCounter =0;
            List<oct222024.TreeNode> nodeList = new ArrayList<>();

            while(!treeQueue.isEmpty()){
                oct222024.TreeNode nd = treeQueue.poll();
                if(nd.left!=null){
                    nodeList.add(nd.left);
                }
                if(nd.right!=null){
                    nodeList.add(nd.right);
                }
            }


            ArrayList<Integer> numList = new ArrayList<>();
            for(oct222024.TreeNode nd1:nodeList){
                treeQueue.offer(nd1);
                numList.add(nd1.val);
            }

            opCounter += calculateMinimumSwaps(numList);

        }

        return opCounter;
    }
    private int calculateMinimumSwaps(ArrayList<Integer> inputList) {
        int totalSwaps = 0;
        ArrayList<Integer> sortedList = new ArrayList<>(inputList);
        Collections.sort(sortedList);

        // Map to track current positions of values
        Map<Integer, Integer> positionsMap = new HashMap<>();
        for (int i = 0; i < inputList.size(); i++) {
            positionsMap.put(inputList.get(i), i);
        }

        // For each position, swap until correct value is placed
        for (int i = 0; i < inputList.size(); i++) {
            if (!inputList.get(i).equals(sortedList.get(i))) {
                totalSwaps++;

                // Update position of swapped values
                int currentPosition = positionsMap.get(sortedList.get(i));
                positionsMap.put(inputList.get(i), currentPosition);
                inputList.set(currentPosition, inputList.get(i));
            }
        }
        return totalSwaps;
    }


}
