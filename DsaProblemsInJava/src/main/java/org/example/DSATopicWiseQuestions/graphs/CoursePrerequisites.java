package org.example.DSATopicWiseQuestions.graphs;

import java.util.ArrayList;
/*
Main point here to learn is that the keeping of stack really helps to find if we are inside the same loop again as in we want to see if a number is parent of its own or it is like a loop situation.
So keep a stack and go ahead , This is like kahn's algorithm
 */
public class CoursePrerequisites {
    public void addEdge(ArrayList<Integer> graph[], int u, int v){
        graph[u].add(v);
    }

    public boolean dfs(ArrayList<Integer> graph[], int vertices){
        boolean vis[] = new boolean[vertices];
        boolean stack[] = new boolean[vertices];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(dfsUtil(i, graph, vis, stack)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfsUtil(int src, ArrayList<Integer> graph[], boolean vis[], boolean stack[]){

        vis[src] = true;
        stack[src] = true;

        for(int i=0; i<graph[src].size(); i++){
            int dest = graph[src].get(i);
            if(!vis[dest]){
                if(dfsUtil(dest, graph, vis, stack)){
                    return true;
                }
            }
            else if(stack[dest]){
                return true;
            }
        }

        stack[src] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<prerequisites.length; i++){
            addEdge(graph, prerequisites[i][0], prerequisites[i][1]);
        }

        return dfs(graph, numCourses);
    }
}
