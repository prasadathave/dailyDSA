package org.example.Jan012025;

import java.util.ArrayList;
import java.util.List;

public class Jan262025 {
    private int maxDepth(int[] visited, int currIndex, int[] favorite, int id, int currDepth, List<Integer> lst)
    {
        if(visited[currIndex]==id){
            if(lst.size()>=2){
                if(lst.get(lst.size()-2)==favorite[lst.get(lst.size()-1)] ||
                        favorite[lst.get(lst.size()-1)]==currIndex
                ){
                    return currDepth;
                }
                else{
                    return currDepth-1;
                }
            }
            else{
                return currDepth;
            }
        }
        visited[currIndex] = id;
        lst.add(currIndex);
        int val =  maxDepth(visited,favorite[currIndex],favorite,id,currDepth+1,lst);
        lst.remove(lst.size()-1);
        return val;
    }
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] cancome = new int[n];
        List<Integer> lst = new ArrayList<>();
        int maxd = -1;
        for(int i=0; i<n; i++){
            int d = maxDepth(cancome,i,favorite,i+1,0,lst);
            if(maxd<d){
                maxd =  d;
            }
        }
        return maxd;
    }
}
