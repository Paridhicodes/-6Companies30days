package Amazon;

import java.util.*;

class Solution {
    public String FirstNonRepeating(String A) {
        // code here
        StringBuilder sb = new StringBuilder("");
        Queue<Character> q = new LinkedList<>();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (!hs.contains(ch)) {
                q.add(ch);
                hs.add(ch);
                sb.append(q.peek());
            } else {
                // while(!q.isEmpty()&&q.peek()==ch){
                // q.remove();
                // }
                if (q.contains(ch)) {
                    q.remove(ch);
                }
                if (q.isEmpty()) {
                    sb.append('#');
                } else {
                    sb.append(q.peek());
                }
            }
        }

        return sb.toString();
    }
}
