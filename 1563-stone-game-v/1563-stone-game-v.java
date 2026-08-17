class Solution {
    private int[][] memo;
    private int[] prefix;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        
        // Initialize memoization table and prefix sum array
        memo = new int[n][n];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            // Precompute prefix sums for O(1) range sum queries
            prefix[i + 1] = prefix[i] + stoneValue[i];
            
            // Fill memo array with -1 to indicate unvisited states
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return dp(0, n - 1);
    }

    // Helper method to get the sum of elements from index i to j inclusive
    private int getSum(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

    private int dp(int i, int j) {
        // Base case: only one stone left, no more moves
        if (i == j) {
            return 0;
        }
        
        // Return cached result if already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxScore = 0;

        // Try all possible split points k
        for (int k = i; k < j; k++) {
            int leftSum = getSum(i, k);
            int rightSum = getSum(k + 1, j);

            if (leftSum < rightSum) {
                // Bob discards the right, Alice plays on the left
                maxScore = Math.max(maxScore, leftSum + dp(i, k));
            } else if (leftSum > rightSum) {
                // Bob discards the left, Alice plays on the right
                maxScore = Math.max(maxScore, rightSum + dp(k + 1, j));
            } else {
                // Sums are equal, Alice decides which half gives a better future score
                maxScore = Math.max(maxScore, leftSum + Math.max(dp(i, k), dp(k + 1, j)));
            }
        }

        // Cache and return the result
        memo[i][j] = maxScore;
        return maxScore;
    }
}