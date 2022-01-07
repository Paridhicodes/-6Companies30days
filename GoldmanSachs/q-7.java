package GoldmanSachs;

class Solution {
    static int findPosition(int N, int M, int K) {
        // code here
        int res = M + K - 1;
        if (res <= N) {
            return res;
        } else {
            int ans = res % N;
            if (ans == 0) {
                return N;
            }
            return ans;
        }
    }
}