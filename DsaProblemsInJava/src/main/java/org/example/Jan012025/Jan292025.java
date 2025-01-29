package org.example.Jan012025;

public class Jan292025 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] arr = new int[edges.length+1];
        for(int[] edg: edges){
            if(arr[edg[0]]==arr[edg[1]] && arr[edg[0]]!=0){
                return new int[]{edg[0],edg[1]};
            }

            if(arr[edg[0]]==0 && arr[edg[1]]==0){
                arr[edg[0]] = edg[0];
                arr[edg[1]] = edg[0];
            }
            else if(arr[edg[0]]!=0 && arr[edg[1]]==0){
                arr[edg[1]] = arr[edg[0]];
            }
            else if(arr[edg[0]]==0 && arr[edg[1]]!=0){
                arr[edg[0]] = arr[edg[1]];
            }

            else if(arr[edg[0]]!=0 && arr[edg[1]]!=0)
            {
                int changed = arr[edg[1]];
                for(int i=0; i<edges.length+1; i++){
                    if(arr[i]==changed){
                        arr[i] = arr[edg[0]];
                    }
                }
            }
        }

        return new int[]{-1,-1};
    }
}
