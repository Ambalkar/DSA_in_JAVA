class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Calculate the prefix sums
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }
        
        // Base case: at the very last index, the player HAS to take all remaining stones.
        int dp = prefix[n - 1];
        
        // Traverse backwards from the second-to-last element down to index 1.
        // Index 0 is skipped because a player must take at least 2 stones (x > 1).
        for (int i = n - 2; i >= 1; i--) {
            // Choice 1: Defer and take whatever the optimal is for the remaining array (dp)
            // Choice 2: Take the stones here (prefix[i]) and subtract the opponent's optimal play (- dp)
            dp = Math.max(dp, prefix[i] - dp);
        }
        
        return dp;
    }
}