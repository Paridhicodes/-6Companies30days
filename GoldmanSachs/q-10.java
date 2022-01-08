package GoldmanSachs;

import java.util.*;

class Solution {
    public int[] findMax(List<Integer> ls) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(ls);
        int[] res = new int[10];
        for (int i = 0; i < 10; i++) {
            res[i] = pq.remove();
        }
        return res;

    }
}