package org.example.nov2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Nov142024 {
    public int minimizeMax(int n, int[] quantities) {
        int productTypes = quantities.length;

        List<int[]> productStorePairList = new ArrayList<>();

        for (int i = 0; i < productTypes; i++) {
            productStorePairList.add(new int[] { quantities[i], 1 });
        }

        PriorityQueue<int[]> productStoreQueue = new PriorityQueue<>((a, b) ->
                Long.compare((long) b[0] * a[1], (long) a[0] * b[1])
        );

        productStoreQueue.addAll(productStorePairList);

        for (int i = 0; i < n - productTypes; i++) {
            int[] maxRatioPair = productStoreQueue.poll();
            int totalStock = maxRatioPair[0];
            int assignedStores = maxRatioPair[1];

            productStoreQueue.offer(
                    new int[] { totalStock, assignedStores + 1 }
            );
        }

        int[] maxRatioPair = productStoreQueue.poll();
        int totalStock = maxRatioPair[0];
        int assignedStores = maxRatioPair[1];

        return (int) Math.ceil(
                (double) totalStock / assignedStores
        );
    }


}
