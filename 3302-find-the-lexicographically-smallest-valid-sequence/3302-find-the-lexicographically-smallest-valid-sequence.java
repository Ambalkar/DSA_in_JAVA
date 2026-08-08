import java.util.*;

public class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // Step 1: Build suffix array
        int[] suffix = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i] = 1 + suffix[i + 1];
                j--;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }

        // Step 2: Greedy selection
        List<Integer> res = new ArrayList<>();
        j = 0;
        boolean usedMismatch = false;

        for (int i = 0; i < n; i++) {
            if (j == m) break;

            if (word1.charAt(i) == word2.charAt(j)) {
                res.add(i);
                j++;
            } else {
                if (!usedMismatch) {
                    // Check if remaining suffix can match
                    if (suffix[i + 1] >= (m - j - 1)) {
                        res.add(i);
                        j++;
                        usedMismatch = true;
                    }
                }
            }
        }

        // Step 3: Check result
        if (res.size() != m) return new int[0];

        // Convert List to array
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}