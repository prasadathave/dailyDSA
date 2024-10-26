package org.example.oct2024;

import java.util.*;

public class oct262024 {
    private int maxDepthBelowNode(TreeNode root, int[] MaxDepthBelowArr){
        if(root==null){
            return -1;
        }
        if(MaxDepthBelowArr[root.val]!=0){
            return MaxDepthBelowArr[root.val];
        }

        MaxDepthBelowArr[root.val] = 1+ Math.max(maxDepthBelowNode(root.left,MaxDepthBelowArr), maxDepthBelowNode(root.right,MaxDepthBelowArr));
        return MaxDepthBelowArr[root.val];
    }

    private Set<Integer> NodeBelowListMap(TreeNode node, Map<Integer, Set<Integer>> nodesBelowMap){
        if (node==null){
            return new HashSet<>();
        }
        nodesBelowMap.putIfAbsent(node.val,new HashSet<>());
        Set<Integer> leftList = NodeBelowListMap(node.left,nodesBelowMap);
        Set<Integer> rightList = NodeBelowListMap(node.right,nodesBelowMap);
        Set<Integer> finalSet = nodesBelowMap.get(node.val);
        if(node.left!=null){
            finalSet.add(node.left.val);
        }
        if(node.right!=null){
            finalSet.add(node.right.val);
        }
        finalSet.add(node.val);
        finalSet.addAll(leftList);
        finalSet.addAll(rightList);
        nodesBelowMap.put(node.val,finalSet);
        //System.out.println("Final Set - "+ finalSet);
        return finalSet;
    }
    private int maxNode(TreeNode root, int lastMax){
        if(root==null){
            return lastMax;
        }
        return Math.max(maxNode(root.left,lastMax),Math.max(maxNode(root.right,lastMax),root.val));
    }

    private void createCurrentDepthMap(TreeNode root, int currDepth, int[] depthArr){
        if (root==null){
            return;
        }
        depthArr[root.val] = currDepth;
        createCurrentDepthMap(root.left,currDepth+1,depthArr);
        createCurrentDepthMap(root.right,currDepth+1,depthArr);
    }

    private boolean isNodeEligible(int nodeIndex,Map<Integer,Set<Integer>> nodesBeloMap,int queryNode){
        Set<Integer> nodeList =nodesBeloMap.get(nodeIndex);
        if(nodeList==null){
            return false;
        }
        return !nodeList.contains(queryNode);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int maxNodeVal = maxNode(root,0);
        int[] nodeDepths = new int[maxNodeVal+1];
        int[] belowDepths = new int[maxNodeVal+1];
        maxDepthBelowNode(root,belowDepths);
        createCurrentDepthMap(root,0,nodeDepths);

        //    for(int i=0; i<maxNodeVal+1; i++){
        //         //System.out.println("belowDepth for -"+i+" is -"+belowDepths[i]);
        //         //System.out.println("nodeDepths for -"+i+" is -"+nodeDepths[i]);
        //    }
        Map<Integer,Set<Integer>> nodesBeloMap = new HashMap<>();
        NodeBelowListMap(root,nodesBeloMap);

        int[] depthListPerQuery = new int[queries.length];
        int index =0;
        for(int removedNode: queries){
            int maxDepthForQuery = 0;
            Set<Integer> affectedNodes = nodesBeloMap.get(removedNode);
            //System.out.println("AffectedNodes - "+affectedNodes);
            for(int i=0; i<maxNodeVal; i++){
                if((isNodeEligible(i,nodesBeloMap,removedNode)) && !affectedNodes.contains(i)){
                    maxDepthForQuery = Math.max(maxDepthForQuery,belowDepths[i]+nodeDepths[i]);
                }

            }
            depthListPerQuery[index] = maxDepthForQuery;
            index++;
        }
        return depthListPerQuery;
    }
}
