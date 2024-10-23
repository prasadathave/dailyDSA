package org.example.oct2024;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class oct222024 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Integer> sumList = new ArrayList<>();
        List<TreeNode> treeNodeQueue = new ArrayList<>();
        treeNodeQueue.add(root);
        treeNodeQueue.add(null);
        int currentSum =0;
        while(!treeNodeQueue.isEmpty()){
            TreeNode treeNode = treeNodeQueue.get(0);
            treeNodeQueue.remove(0);
            if(treeNode!=null) {
                currentSum += treeNode.val;
                if(treeNode.left!=null) {
                    treeNodeQueue.add(treeNode.left);
                }
                if(treeNode.right!=null) {
                    treeNodeQueue.add(treeNode.right);
                }
            }
            else{
                sumList.add(currentSum);
                currentSum =0;
                treeNodeQueue.add(null);
                if(allElementsAreNull(treeNodeQueue)){
                    break;
                }
            }
        }

        if(sumList.size()<k){
            return -1;
        }
        else{
            List<Integer> sortedValues = sumList.stream().sorted().toList();
            return sortedValues.get(sortedValues.size()-k);
        }
    }

    private boolean allElementsAreNull(List<TreeNode> treeNodeQueue) {
        boolean allElementsAreNull =true;
        for(TreeNode treeNode:treeNodeQueue){
            if(treeNode!=null){
                allElementsAreNull =false;
                break;
            }
        }
        return allElementsAreNull;
    }
}
