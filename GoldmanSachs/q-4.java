package GoldmanSachs;

class GfG {
    String encode(String str) {
        // Your code here
        char ch = str.charAt(0);
        int len = 1;
        if (str.length() == 1) {
            return ch + "1";
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == ch) {
                len++;
            } else {
                sb.append(ch);
                sb.append(len);
                ch = curr;
                len = 1;
            }

            if (i == str.length() - 1) {
                sb.append(ch);
                sb.append(len);
            }
        }
        return sb.toString();
    }

}
