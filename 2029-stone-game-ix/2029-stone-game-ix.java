class Solution {
    public boolean stoneGameIX(int[] stones) {
        // Count the frequencies of remainders when divided by 3
        int[] counts = new int[3];
        for (int stone : stones) {
            counts[stone % 3]++;
        }
        
        int c0 = counts[0];
        int c1 = counts[1];
        int c2 = counts[2];
        
        // If the number of 0s is even, they essentially cancel out.
        if (c0 % 2 == 0) {
            // Alice wins as long as she has both a 1 and a 2 available to start.
            return c1 > 0 && c2 > 0;
        } 
        // If the number of 0s is odd, Bob gets a turn-parity advantage.
        else {
            // Alice can only win if there is a large difference between 1s and 2s.
            return Math.abs(c1 - c2) > 2;
        }
    }
}