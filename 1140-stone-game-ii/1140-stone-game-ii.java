class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // suffix sum array
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        
        // dp[i][M] memo table
        int[][] dp = new int[n][n + 1];
        
        return dfs(0, 1, piles, suffix, dp);
    }
    
    private int dfs(int i, int M, int[] piles, int[] suffix, int[][] dp) {
        int n = piles.length;
        
        // if all piles taken
        if (i >= n) return 0;
        
        // memoized result
        if (dp[i][M] != 0) return dp[i][M];
        
        // can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }
        
        int best = 0;
        
        // try all X from 1 to 2M
        for (int X = 1; X <= 2 * M; X++) {
            int opponent = dfs(i + X, Math.max(M, X), piles, suffix, dp);
            best = Math.max(best, suffix[i] - opponent);
        }
        
        dp[i][M] = best;
        return best;
    }
}