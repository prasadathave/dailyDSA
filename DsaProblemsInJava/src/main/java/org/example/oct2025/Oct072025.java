package org.example.oct2025;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Oct072025 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> full = new HashMap<>();  // lake -> last filled day
        TreeSet<Integer> dryDays = new TreeSet<>();    // indices of zero days

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);  // we can use this day later to dry some lake
                ans[i] = 1;      // default value (in case we don’t use it)
            } else {
                int lake = rains[i];
                ans[i] = -1; // raining day
                if (full.containsKey(lake)) {
                    // lake already full before -> must dry it before today
                    Integer dryDay = dryDays.ceiling(full.get(lake) + 1);
                    if (dryDay == null) {
                        return new int[0]; // no suitable dry day -> flood
                    }
                    ans[dryDay] = lake; // dry this lake on that day
                    dryDays.remove(dryDay);
                }
                full.put(lake, i); // mark this lake as filled today
            }
        }

        return ans;
    }
}
