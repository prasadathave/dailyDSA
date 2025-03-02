import java.util.*;

public class March022025 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> mp1 = new HashMap<>();
        Map<Integer,Integer> mp2 = new HashMap<>();
        SortedSet<Integer> hs = new TreeSet<>();
        for(int[] pr:nums1){
            mp1.put(pr[0],pr[1]);
            hs.add(pr[0]);
        }
        for(int[] pr:nums2){
            mp2.put(pr[0],pr[1]);
            hs.add(pr[0]);
        }

        List<int[]> lst = new ArrayList<>();
        for(int num:hs){
            lst.add(new int[]{num,mp1.getOrDefault(num,0)+mp2.getOrDefault(num,0)});
        }
        int[][] result = new int[lst.size()][2];
        for(int i=0; i<lst.size(); i++){
            result[i] = lst.get(i);
        }
        return result;
    }
}
