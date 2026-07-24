class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAXX = 2048;

        boolean[][] dp = new boolean[4][MAXX];
        dp[0][0] = true;

        for (int v : nums) {
            boolean[][] next = new boolean[4][MAXX];

            // Copy current states (choosing this element 0 times)
            for (int i = 0; i < 4; i++) {
                System.arraycopy(dp[i], 0, next[i], 0, MAXX);
            }

            for (int cnt = 0; cnt < 3; cnt++) {
                for (int x = 0; x < MAXX; x++) {
                    if (!dp[cnt][x]) continue;

                    // Take current element once
                    next[cnt + 1][x ^ v] = true;

                    // Take current element twice
                    if (cnt + 2 <= 3) {
                        next[cnt + 2][x] = true;
                    }

                    // Take current element three times
                    if (cnt + 3 <= 3) {
                        next[cnt + 3][x ^ v] = true;
                    }
                }
            }

            dp = next;
        }

        int ans = 0;
        for (boolean b : dp[3]) {
            if (b) ans++;
        }

        return ans;
    }
}