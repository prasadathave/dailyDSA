package org.example.dec2024;

import java.util.ArrayList;
import java.util.List;

public class Dec242024 {
    // Need to optimize the diameter finding by merging the max lengths from connecting two


        private int getMaxDepth(int currentDepth,int currentNode, int parentNode,List<List<Integer>> graph)
        {
            int maxDepth =-1;
            for(int node: graph.get(currentNode)){
                if(node!=parentNode){
                    int dpth = getMaxDepth(currentDepth+1,node,currentNode,graph);
                    if(dpth>maxDepth){
                        maxDepth = dpth;
                    }
                }
            }

            if(maxDepth==-1){
                return currentDepth;
            }
            return maxDepth;
        }



        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            int v1 = -1;
            for(int i=0; i<edges1.length; i++){
                if(edges1[i][0]>v1){
                    v1 = edges1[i][0];
                }
                if(edges1[i][1]>v1){
                    v1=edges1[i][1];
                }
            }
            v1+=1;
            int v2 = -1;
            for(int i=0; i<edges2.length; i++){
                if(edges2[i][0]>v2){
                    v2 = edges2[i][0];
                }
                if(edges2[i][1]>v2){
                    v2=edges2[i][1];
                }
            }
            v2 +=1;

            List<List<Integer>> graph1 = new ArrayList<>();
            List<List<Integer>> graph2 = new ArrayList<>();
            for(int i=0; i<v1; i++){
                graph1.add(new ArrayList<>());
            }
            for(int i =0; i<v2; i++){
                graph2.add(new ArrayList<>());
            }

            for(int[] edge: edges1){
                graph1.get(edge[0]).add(edge[1]);
                graph1.get(edge[1]).add(edge[0]);
            }

            for(int[] edge : edges2){
                graph2.get(edge[0]).add(edge[1]);
                graph2.get(edge[1]).add(edge[0]);
            }

            int maxDepthGraph1 = -1;
            int minDepthGraph1 = Integer.MAX_VALUE;
            for(int i=0; i<v1; i++){
                int dpth = getMaxDepth(0,i,-1,graph1);
                if(dpth>maxDepthGraph1){
                    maxDepthGraph1 = dpth;
                }
                if(dpth<minDepthGraph1){
                    minDepthGraph1 = dpth;
                }
            }
            if(maxDepthGraph1==-1){
                maxDepthGraph1 =0;
            }
            if(minDepthGraph1==Integer.MAX_VALUE){
                minDepthGraph1 =0;
            }

            int maxDepthGraph2 = -1;
            int minDepthGraph2 = Integer.MAX_VALUE;
            for(int i=0; i<v2; i++){
                int dpth = getMaxDepth(0,i,-1,graph2);
                if(dpth>maxDepthGraph2){
                    maxDepthGraph2 = dpth;
                }
                if(dpth<minDepthGraph2){
                    minDepthGraph2 = dpth;
                }
            }

            if(maxDepthGraph2==-1){
                maxDepthGraph2 =0;
            }
            if(minDepthGraph2==Integer.MAX_VALUE){
                minDepthGraph2 =0;
            }

            int n1 = Math.max(maxDepthGraph2,maxDepthGraph1);
            int n2 = Math.max(n1, minDepthGraph2+minDepthGraph1+1);

            return n2;
        }
    // optimal diameter calculation -
    private Pair computeDiameter(
            List<List<Integer>> adjList,
            int currentNode,
            int parentNode
    ) {
        int maxDepth1 = 0, maxDepth2 = 0; // Tracks the two largest depths from the current node
        int treeDiameter = 0; // Tracks the diameter of the subtree

        for (int neighbor : adjList.get(currentNode)) {
            if (neighbor == parentNode) continue; // Skip the parent to avoid cycles

            // Recursively calculate the diameter and depth of the neighbor's subtree
            Pair result = computeDiameter(adjList, neighbor, currentNode);
            int neighborDiameter = result.getFirst();
            int neighborDepth = result.getSecond() + 1; // Increment depth to include edge to neighbor

            // Update the maximum diameter of the subtree
            treeDiameter = Math.max(treeDiameter, neighborDiameter);

            // Update the two largest depths from the current node
            if (neighborDepth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = neighborDepth;
            } else if (neighborDepth > maxDepth2) {
                maxDepth2 = neighborDepth;
            }
        }

        // Update the diameter to include the path through the current node
        treeDiameter = Math.max(treeDiameter, maxDepth1 + maxDepth2);

        // Return the diameter and the longest depth
        return new Pair(treeDiameter, maxDepth1);
    }

    // Simple Pair class for storing results of the computeDiameter function
    class Pair {

        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}
