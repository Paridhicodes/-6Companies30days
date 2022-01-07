package GoldmanSachs;

import java.util.*;

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (int i = 0; i < string_list.length; i++) {
            char ch[] = string_list[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (!hm.containsKey(s)) {
                hm.put(s, new ArrayList<>());
            }

            hm.get(s).add(string_list[i]);
        }

        HashSet<String> hs = new HashSet<>();
        List<List<String>> ls = new ArrayList<>();
        for (int i = 0; i < string_list.length; i++) {
            char ch[] = string_list[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (!hs.contains(s)) {
                hs.add(s);
                ls.add(hm.get(s));
            }

        }
        return ls;
    }
}
