package org.example.Jan012025;

import java.util.HashSet;

public class Jan142025 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        int rsp =0;
        HashSet<Integer> Aset = new HashSet<>();
        HashSet<Integer> Bset = new HashSet<>();

        for(int i=0; i<A.length; i++){
            Aset.add(A[i]);
            Bset.add(B[i]);
            HashSet<Integer> Cset = new HashSet<>();
            Cset.addAll(Aset);
            Cset.retainAll(Bset);
            int length = Cset.size();
            result[rsp++] = length;
        }
        return result;
    }
}
