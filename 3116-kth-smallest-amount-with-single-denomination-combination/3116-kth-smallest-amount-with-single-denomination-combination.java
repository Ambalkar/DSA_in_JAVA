class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        // Array to store the LCM of every possible subset of coins
        long[] lcms = new long[1 << n];
        lcms[0] = 1; 

        // Precompute the LCM for all 2^n subsets using bitmasking
        for (int mask = 1; mask < (1 << n); mask++) {
            int leastSignificantBit = Integer.numberOfTrailingZeros(mask);
            int prevMask = mask ^ (1 << leastSignificantBit);
            lcms[mask] = lcm(lcms[prevMask], coins[leastSignificantBit]);
        }

        // Binary search bounds
        long minCoin = coins[0];
        for (int c : coins) {
            minCoin = Math.min(minCoin, c);
        }
        
        long left = 1;
        long right = minCoin * k;

        // Binary search for the exact kth amount
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countAmounts(mid, lcms, n) >= k) {
                right = mid; // Narrow down the ceiling
            } else {
                left = mid + 1; // Increase the floor
            }
        }

        return left;
    }

    // Uses PIE to count how many valid amounts exist <= mid
    private long countAmounts(long mid, long[] lcms, int n) {
        long count = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long multiples = mid / lcms[mask];
            
            // If the subset size is odd, add it. If even, subtract it.
            if (Integer.bitCount(mask) % 2 == 1) {
                count += multiples;
            } else {
                count -= multiples;
            }
        }
        return count;
    }

    // Helper method to find Greatest Common Divisor
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper method to find Least Common Multiple
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}