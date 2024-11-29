package org.example.DSATopicWiseQuestions.graphs;

import java.util.*;

class NodeElem{
    private int nodeId;
    private int nodeWeightFromLastPoint;

    NodeElem(int nodeId, int nodeWeightFromLastPoint){

        this.nodeId = nodeId;
        this.nodeWeightFromLastPoint = nodeWeightFromLastPoint;
    }

    public int getNodeId() {
        return nodeId;
    }

    public int getNodeWeightFromLastPoint() {
        return nodeWeightFromLastPoint;
    }

    @Override public boolean equals(Object object){
        try{
            NodeElem nodeElem = (NodeElem) object;
            return nodeElem.nodeId==nodeId && nodeElem.nodeWeightFromLastPoint == nodeWeightFromLastPoint;
        }
        catch (Exception e){
            return false;
        }
    }

}

public class Graph {
    private List<List<NodeElem>> graphNodesFromANodeList;

    Graph(int numNodes){
        graphNodesFromANodeList = new ArrayList<>();
        for(int i=0; i<numNodes; i++){
            graphNodesFromANodeList.add(new ArrayList<>());
        }
    }
    Graph(){
        graphNodesFromANodeList = new ArrayList<>();
    }

    public void addWeightedEdge(int source, int destination,int weight){
        while(source>=graphNodesFromANodeList.size() || destination>=graphNodesFromANodeList.size()){
            graphNodesFromANodeList.add(new ArrayList<>());
        }
        graphNodesFromANodeList.get(source).add(new NodeElem(destination,weight));
    }

    public int[] minDistFromSource(int source){
        int[] distance = new int[graphNodesFromANodeList.size()];
        List<Integer> nodeQueue = new ArrayList<>();
        for(int i=0; i<distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        nodeQueue.add(source);

        while(!nodeQueue.isEmpty()){

            int minNode = nodeQueue.get(0);
            for(int node:nodeQueue){
                if(distance[minNode]>distance[node]){
                    minNode = node;
                }
            }
            nodeQueue.remove((Integer) minNode);
            for(NodeElem neighbor:graphNodesFromANodeList.get(minNode)){
                if(distance[neighbor.getNodeId()]>distance[minNode]+neighbor.getNodeWeightFromLastPoint()){
                    nodeQueue.add(neighbor.getNodeId());
                    distance[neighbor.getNodeId()] = distance[minNode]+neighbor.getNodeWeightFromLastPoint();
                }
            }

        }
        return distance;
    }

    public ArrayList<Integer> minDistInNegativeWeights(int src){
        ArrayList<Integer> distance = new ArrayList<>();
        for(int i=0; i<graphNodesFromANodeList.size(); i++){
            distance.add(Integer.MAX_VALUE);
        }
        distance.set(src,0);

        for(int i=0; i<graphNodesFromANodeList.size()-1; i++){
            for(int j=0; j<graphNodesFromANodeList.size(); j++){
                for(NodeElem nodeElem:graphNodesFromANodeList.get(j)){
                    if(distance.get(j)!=Integer.MAX_VALUE){
                        int minVal = Math.min(distance.get(nodeElem.getNodeId()),distance.get(j)+nodeElem.getNodeWeightFromLastPoint());
                        distance.set(nodeElem.getNodeId(),minVal);
                    }
                }
            }
        }

        return distance;
    }

    public List<int[]> minimumSpanningTree(int src){
        int[] visited = new int[graphNodesFromANodeList.size()];
        for(int i=0; i<visited.length; i++){
            visited[i] = -1;
        }
        int visitCounter =0;


        visited[src] = 1;

       List<int[]> edgeList = new ArrayList<>();
       while(visitCounter<graphNodesFromANodeList.size()-1){
           ArrayList<Integer> minEdge = getMinEdgeInVisited(visited);
           if(minEdge.get(0)==-1){
               break;
           }
           int[] edge = new int[3];
           edge[0] = minEdge.get(0);
           edge[1] = minEdge.get(1);
           edge[2] = minEdge.get(2);
           edgeList.add(edge);
           visited[minEdge.get(2)] = 1;
           visitCounter++;
       }

       return edgeList;

    }

    private ArrayList<Integer> getMinEdgeInVisited(int[] visited) {
        int minEdgeWeight = Integer.MAX_VALUE;
        int minSource = -1;
        int minDest = -1;
        for(int i=0; i<visited.length; i++){
            if(visited[i]!=-1){
                for(NodeElem nodeElem: graphNodesFromANodeList.get(i)){
                    if(visited[nodeElem.getNodeId()]==-1 && nodeElem.getNodeWeightFromLastPoint()<minEdgeWeight){
                        minDest = nodeElem.getNodeId();
                        minSource = i;
                        minEdgeWeight = nodeElem.getNodeWeightFromLastPoint();
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minSource);
        result.add(minDest);
        result.add(minEdgeWeight);

        return result;
    }


}
