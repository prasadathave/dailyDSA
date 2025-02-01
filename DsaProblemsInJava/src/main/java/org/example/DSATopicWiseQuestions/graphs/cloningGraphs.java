package org.example.DSATopicWiseQuestions.graphs;

import java.util.*;

public class cloningGraphs {
    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private int getMaxNode(Node nd){
        HashSet<Integer> st = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(nd);
        while(!q.isEmpty()){
            Node n1 = q.poll();
            st.add(n1.val);
            for(Node n:n1.neighbors){
                if(!st.contains(n.val)){
                    q.offer(n);
                }
            }
        }
        int maxVal = 0;
        for(int v:st){
            if(v>maxVal){
                maxVal = v;
            }
        }
        return maxVal;
    }

    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        int mval = getMaxNode(node);

        List<Set<Integer>> lst = new ArrayList<>();
        for(int i=0; i<=mval; i++){
            lst.add(new HashSet<>());
        }

        HashSet<Integer> st = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node abc = q.poll();
            st.add(abc.val);
            Set<Integer> nodeSpecList = lst.get(abc.val);
            for(Node ch: abc.neighbors){
                nodeSpecList.add(ch.val);
                if(!st.contains(ch.val)){
                    q.offer(ch);
                }
            }
        }

        List<Node> ndList = new ArrayList<>();
        for(int i=0; i<=mval; i++){
            ndList.add(new Node(i));
        }
        for(int i=0; i<lst.size(); i++){
            for(int j:lst.get(i)){
                ndList.get(i).neighbors.add(ndList.get(j));
            }
        }
        return ndList.get(1);
    }

    public Node cloneGraphUpdated(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    public Node dfs(Node node, HashMap<Node, Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node neighbor : node.neighbors){
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
}
