import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Long, Integer> memo;

    public String smallestNumber(String num, long t) {
        // Step 1: Check if t can be formed by digits 1-9 (only prime factors 2, 3, 5, 7)
        if (!checkT(t)) {
            return "-1";
        }

        memo = new HashMap<>();
        
        // Step 2: Check if num itself is already a valid answer
        boolean hasZero = false;
        long rem = t;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == '0') {
                hasZero = true;
            }
            if (!hasZero) {
                rem /= gcd(rem, c - '0');
            }
        }
        if (!hasZero && rem == 1) {
            return num;
        }

        int n = num.length();
        int zIdx = num.indexOf('0');
        // We can only keep prefixes that come before the first '0'
        int maxI = zIdx == -1 ? n - 1 : zIdx;

        // Precompute the remaining target product for every prefix of num
        long[] prefRem = new long[maxI + 2];
        prefRem[0] = t;
        for (int i = 0; i <= maxI; i++) {
            prefRem[i + 1] = prefRem[i] / gcd(prefRem[i], num.charAt(i) - '0');
        }

        // Step 3: Find the longest prefix we can keep unchanged
        for (int i = maxI; i >= 0; i--) {
            long vI = prefRem[i];
            int lRem = n - 1 - i;
            int startD = (num.charAt(i) - '0') + 1;

            for (int d = startD; d <= 9; d++) {
                long nxtV = vI / gcd(vI, d);

                // If it's possible to fulfill the remaining product in the remaining length
                if (getMinLen(nxtV) <= lRem) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);

                    long currV = nxtV;
                    // Greedily construct the lexicographically smallest suffix
                    for (int step = 0; step < lRem; step++) {
                        for (int c = 1; c <= 9; c++) {
                            long nextC = currV / gcd(currV, c);
                            if (getMinLen(nextC) <= lRem - 1 - step) {
                                sb.append(c);
                                currV = nextC;
                                break;
                            }
                        }
                    }
                    return sb.toString();
                }
            }
        }

        // Step 4: If no same-length modification works, increase the string length
        int lNew = Math.max(n + 1, getMinLen(t));
        StringBuilder sb = new StringBuilder();
        long currV = t;
        
        for (int step = 0; step < lNew; step++) {
            for (int c = 1; c <= 9; c++) {
                long nextC = currV / gcd(currV, c);
                if (getMinLen(nextC) <= lNew - 1 - step) {
                    sb.append(c);
                    currV = nextC;
                    break;
                }
            }
        }

        return sb.toString();
    }

    // Helper: Validates if `t` has only prime factors {2, 3, 5, 7}
    private boolean checkT(long t) {
        long[] primes = {2, 3, 5, 7};
        for (long p : primes) {
            while (t % p == 0) {
                t /= p;
            }
        }
        return t == 1;
    }

    // Helper: Computes GCD of two longs
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper: Memoized DP to find the minimum number of digits needed to form `v`
    private int getMinLen(long v) {
        if (v == 1) return 0;
        if (memo.containsKey(v)) return memo.get(v);
        
        int ans = Integer.MAX_VALUE / 2; // Use a safe large number to avoid overflow
        for (int d = 2; d <= 9; d++) {
            long g = gcd(v, d);
            if (g > 1) {
                ans = Math.min(ans, 1 + getMinLen(v / g));
            }
        }
        
        memo.put(v, ans);
        return ans;
    }
}