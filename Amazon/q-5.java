package Amazon;
//User function Template for Java

import java.util.*;

class Solution {
    static ArrayList<ArrayList<String>> displayContacts(int n,
            String contact[], String s) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 1; i <= s.length(); i++) {
            boolean zeroCheck = false;
            String str = s.substring(0, i);
            for (int j = 0; j < contact.length; j++) {
                if (contact[j].length() < str.length()) {
                    continue;
                }

                String prefix = contact[j].substring(0, str.length());
                if (str.equals(prefix) && !pq.contains(contact[j])) {
                    zeroCheck = true;
                    pq.add(contact[j]);
                }
            }
            res.add(new ArrayList<>());
            if (zeroCheck == false) {
                res.get(i - 1).add("0");
            } else {

                while (!pq.isEmpty()) {
                    res.get(i - 1).add(pq.remove());
                }
            }
        }
        return res;
    }
}

class q-5 {
    
}
