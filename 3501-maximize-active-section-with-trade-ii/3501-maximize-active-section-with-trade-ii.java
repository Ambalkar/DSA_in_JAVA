import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int totalOnes = prefix[n];

        List<int[]> runsList = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                int j = i;
                while (j < n && s.charAt(j) == '1') j++;
                runsList.add(new int[]{i, j - 1});
                i = j;
            } else {
                i++;
            }
        }
        int m = runsList.size();
        int q = queries.length;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(q, 0));

        if (m == 0) {
            for (int k = 0; k < q; k++) ans.set(k, totalOnes);
            return ans;
        }

        int[] A = new int[m], B = new int[m];
        int[] LZS = new int[m], RZE = new int[m];
        int[] L = new int[m], R = new int[m];

        for (int k = 0; k < m; k++) {
            A[k] = runsList.get(k)[0];
            B[k] = runsList.get(k)[1];
        }
        for (int k = 0; k < m; k++) {
            LZS[k] = (k > 0) ? (B[k - 1] + 1) : 0;
            L[k] = A[k] - LZS[k];
            RZE[k] = (k < m - 1) ? (A[k + 1] - 1) : (n - 1);
            R[k] = RZE[k] - B[k];
        }

        long[] arrA = new long[m], arrB = new long[m], arrC = new long[m], arrD = new long[m];
        for (int k = 0; k < m; k++) {
            arrA[k] = (long) L[k] + R[k];
            arrB[k] = (long) L[k] - B[k];
            arrC[k] = (long) A[k] + R[k];
            arrD[k] = (long) A[k] - B[k];
        }

        SparseTable tblA = new SparseTable(arrA);
        SparseTable tblB = new SparseTable(arrB);
        SparseTable tblC = new SparseTable(arrC);
        SparseTable tblD = new SparseTable(arrD);

        for (int qi = 0; qi < q; qi++) {
            int l = queries[qi][0], r = queries[qi][1];

            int lo = upperBound(A, l);
            int hi = lowerBound(B, r) - 1;

            if (lo > hi || lo >= m || hi < 0) {
                ans.set(qi, totalOnes);
                continue;
            }

            int p = lowerBound(LZS, l);
            int qq = upperBound(RZE, r) - 1;

            Long best = null;

            Long v = tblA.query(Math.max(lo, p), Math.min(hi, qq));
            if (v != null) best = v;

            v = tblB.query(Math.max(lo, Math.max(p, qq + 1)), hi);
            if (v != null) {
                v += r;
                best = (best == null) ? v : Math.max(best, v);
            }

            v = tblC.query(lo, Math.min(hi, Math.min(qq, p - 1)));
            if (v != null) {
                v -= l;
                best = (best == null) ? v : Math.max(best, v);
            }

            v = tblD.query(Math.max(lo, qq + 1), Math.min(hi, p - 1));
            if (v != null) {
                v += (r - l);
                best = (best == null) ? v : Math.max(best, v);
            }

            long gain = (best == null) ? 0 : Math.max(0L, best);
            ans.set(qi, (int) (totalOnes + gain));
        }

        return ans;
    }

    private int upperBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int lowerBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static class SparseTable {
        long[][] table;
        int[] log;
        int n;

        SparseTable(long[] arr) {
            n = arr.length;
            log = new int[n + 1];
            for (int i = 2; i <= n; i++) log[i] = log[i / 2] + 1;
            int K = log[n] + 1;
            table = new long[K][];
            table[0] = arr.clone();
            for (int j = 1; j < K; j++) {
                int half = 1 << (j - 1);
                int len = n - (1 << j) + 1;
                if (len <= 0) break;
                table[j] = new long[len];
                for (int k = 0; k < len; k++) {
                    table[j][k] = Math.max(table[j - 1][k], table[j - 1][k + half]);
                }
            }
        }

        Long query(int l0, int r0) {
            if (l0 > r0 || l0 < 0 || r0 >= n) return null;
            int k = log[r0 - l0 + 1];
            if (table[k] == null) return null;
            long a = table[k][l0];
            long b = table[k][r0 - (1 << k) + 1];
            return Math.max(a, b);
        }
    }
}