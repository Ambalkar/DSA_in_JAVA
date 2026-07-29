import java.util.*;

class Solution {
    static final long LIMIT = 1_000_000L;

    long[][] comb;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int[] half = new int[26];
        int halfLen = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1) mid = (char) ('a' + i);
        }

        buildComb(halfLen);

        if (countWays(half) < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (mid != 0) ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private void buildComb(int n) {
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = Math.min(LIMIT + 1, comb[i - 1][j - 1] + comb[i - 1][j]);
            }
        }
    }

    private long countWays(int[] cnt) {
        int rem = 0;
        for (int x : cnt) rem += x;

        long ways = 1;
        int left = rem;

        for (int x : cnt) {
            if (x == 0) continue;

            ways = Math.min(LIMIT + 1, ways * comb[left][x]);
            if (ways > LIMIT) ways = LIMIT + 1;

            left -= x;
        }

        return ways;
    }
}