package Amazon;

class Solution {
    // Function to count number of ways to reach the nth stair
    // when order does not matter.
    Long countWays(int m) {
        // your code here
        long[] dp = new long[m + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= m; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + 1;
        }
        return dp[m];
    }
}
