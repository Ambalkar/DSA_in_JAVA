class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        // Array to count frequencies since 0 <= nums[i] <= 50
        int[] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }
        
        int maxVal = -1;
        
        // Case 1: k is the length of the array
        if (k == n) {
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }
        } 
        // Case 2: k is 1
        else if (k == 1) {
            for (int num : nums) {
                if (freq[num] == 1) {
                    maxVal = Math.max(maxVal, num);
                }
            }
        } 
        // Case 3: 1 < k < n
        else {
            if (freq[nums[0]] == 1) {
                maxVal = Math.max(maxVal, nums[0]);
            }
            if (freq[nums[n - 1]] == 1) {
                maxVal = Math.max(maxVal, nums[n - 1]);
            }
        }
        
        return maxVal;
    }
}