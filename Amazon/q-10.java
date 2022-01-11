package Amazon;

import java.util.*;

class Solution {
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here

        HashMap<Character, Integer> hs = new HashMap<>();
        hs.put('!', 1);
        hs.put('#', 2);
        hs.put('$', 3);
        hs.put('%', 4);
        hs.put('&', 5);
        hs.put('*', 6);
        hs.put('@', 7);
        hs.put('^', 8);
        hs.put('~', 9);

        PriorityQueue<Nut> pq = new PriorityQueue<>();
        for (int i = 0; i < nuts.length; i++) {
            pq.add(new Nut(nuts[i], hs.get(nuts[i])));
        }

        int i = 0;
        while (!pq.isEmpty()) {
            Nut curr = pq.remove();
            nuts[i] = curr.ch;
            bolts[i] = curr.ch;
            i++;
        }
    }
}

class Nut implements Comparable<Nut> {
    char ch;
    int p;

    public Nut(char ch, int p) {
        this.ch = ch;
        this.p = p;
    }

    public int compareTo(Nut o) {
        return this.p - o.p;
    }
}
