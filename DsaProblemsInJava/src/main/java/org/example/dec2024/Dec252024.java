package org.example.dec2024;

import org.example.oct2024.oct222024;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.example.oct2024.oct222024.*;
public class Dec252024 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<oct222024.TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()){

            List<TreeNode> temp = new ArrayList<>();
            while(!nodeQueue.isEmpty()){
                temp.add(nodeQueue.poll());
            }

            int levelMax =Integer.MIN_VALUE;
            for(TreeNode nd: temp){
                if(levelMax<nd.val){
                    levelMax = nd.val;
                }
                if(nd.left!=null){
                    nodeQueue.offer(nd.left);
                }
                if(nd.right!=null){
                    nodeQueue.offer(nd.right);
                }
            }
            result.add(levelMax);
        }
        return result;
    }
}
