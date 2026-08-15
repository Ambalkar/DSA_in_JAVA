class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean hasNonZero = false;
        
        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }
        
        // Case 1: The whole array has a non-zero XOR
        if (totalXor != 0) {
            return nums.length;
        }
        
        // Case 2: The total XOR is 0, but we have at least one non-zero element to remove
        if (hasNonZero) {
            return nums.length - 1;
        }
        
        // Case 3: All elements are 0
        return 0;
    }
}