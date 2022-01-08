package GoldmanSachs;

import java.util.*;

//User function Template for Java
class Solution {
    static String printMinNumberForPattern(String S) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        int firstp = 0;
        int secp = 1;
        if (S.charAt(0) == 'I') {
            res.add("1");
            res.add("2");
        } else {
            res.add("2");
            res.add("1");
        }

        int currNum = 3;
        char prev = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (prev == 'D') {
                if (ch == 'D') {
                    res.add(firstp, currNum + "");
                } else {
                    res.add(currNum + "");
                }
            } else {
                if (ch == 'D') {
                    res.add(secp, currNum + "");
                    firstp = secp;
                } else {
                    res.add(currNum + "");
                }
            }
            prev = ch;
            secp = res.size() - 1;
            currNum++;
        }

        StringBuilder sb = new StringBuilder("");
        for (String str : res) {
            sb.append(str);
        }
        return sb.toString();
    }
}
