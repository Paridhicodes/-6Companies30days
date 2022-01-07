package GoldmanSachs;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        boolean flag = true;
        if (str2.length() > str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        while (flag) {
            int len2 = str2.length();
            int len1 = str1.length();
            int i = 0;
            for (i = 0; i + (len2 - 1) < len1; i += len2) {
                String sub = str1.substring(i, i + len2);
                if (!sub.equals(str2)) {
                    return "";
                }
            }
            if (i == len1) {
                return str2;
            }
            String temp = str2;
            str2 = str1.substring(i, len1);
            str1 = temp;
        }
        return "";
    }
}
