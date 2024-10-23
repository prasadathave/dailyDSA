package org.example.oct2024;

import java.util.HashMap;
import java.util.Map;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left, TreeNode right){
        this.left = left;
        this.right =right;
        this.val = val;
    }
}
public class oct232024 {
    private void updateSum(TreeNode treeNode,int level,Map<Integer,Integer> sumMap){
        sumMap.putIfAbsent(level, 0);

        sumMap.compute(level, (k, currentSumOfLevel) -> currentSumOfLevel + treeNode.val);
        if(treeNode.left!=null){
            updateSum(treeNode.left,level+1,sumMap);
        }
        if(treeNode.right!=null){
            updateSum(treeNode.right,level+1,sumMap);
        }

    }
    private Map<Integer,Integer> levelWiseSumMap(TreeNode treeNode){
        HashMap<Integer,Integer> levelWiseMap = new HashMap<>();
        updateSum(treeNode,0,levelWiseMap);
        return levelWiseMap;
    }
    private void updateValuesInTree(TreeNode treeNode, int siblingValue,Map<Integer,Integer> levelWiseMap,int level){
        System.out.println("current Val for node - "+treeNode.val+ " sibling val -"+siblingValue+" level Sum - "+levelWiseMap.get(level));
        treeNode.val = (levelWiseMap.get(level) - siblingValue- treeNode.val);
        if(treeNode.left!=null && treeNode.right!=null){
            int leftValue = treeNode.left.val;
            int rightValue = treeNode.right.val;
            updateValuesInTree(treeNode.left,rightValue,levelWiseMap,level+1);
            updateValuesInTree(treeNode.right,leftValue,levelWiseMap,level+1);
        }
        else if(treeNode.left!=null){
            updateValuesInTree(treeNode.left,0,levelWiseMap,level+1);
        }
        else if(treeNode.right!=null){
            updateValuesInTree(treeNode.right,0,levelWiseMap,level+1);
        }
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer,Integer> sumMap = levelWiseSumMap(root);
        updateValuesInTree(root,0,sumMap,0);
        return root;
    }
}
