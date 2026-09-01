import java.util.Arrays;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Store the value and its original index
        int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i][0] = nums[i];
            paired[i][1] = i;
        }
        
        // Sort pairs primarily by value
        Arrays.sort(paired, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int i = 0;
        
        // Group elements into connected components
        while (i < n) {
            int j = i + 1;
            
            // Expand the current component as long as adjacent differences are <= limit
            while (j < n && paired[j][0] - paired[j - 1][0] <= limit) {
                j++;
            }
            
            // Extract the original indices for this component
            int[] indices = new int[j - i];
            for (int k = i; k < j; k++) {
                indices[k - i] = paired[k][1];
            }
            
            // Sort the original indices to place the smallest values at the earliest available spots
            Arrays.sort(indices);
            
            // Place the sorted values back into the sorted indices
            for (int k = i; k < j; k++) {
                result[indices[k - i]] = paired[k][0];
            }
            
            // Move to the next component
            i = j;
        }
        
        return result;
    }
}