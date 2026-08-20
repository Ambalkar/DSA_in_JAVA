class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        
        // Arrays to hold the distributed elements. 
        // Max size can be 'n' if all remaining elements go to one array.
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        // Pointers to track the size/last element of arr1 and arr2
        int count1 = 0;
        int count2 = 0;
        
        // 1st operation: append nums[0] to arr1 (since the problem description is 1-indexed)
        arr1[count1++] = nums[0];
        // 2nd operation: append nums[1] to arr2
        arr2[count2++] = nums[1];
        
        // Iterate through the rest of the elements starting from index 2
        for (int i = 2; i < n; i++) {
            // Compare the last elements of arr1 and arr2
            if (arr1[count1 - 1] > arr2[count2 - 1]) {
                arr1[count1++] = nums[i];
            } else {
                arr2[count2++] = nums[i];
            }
        }
        
        // Concatenate arr1 and arr2 into the result array
        int[] result = new int[n];
        for (int i = 0; i < count1; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < count2; i++) {
            result[count1 + i] = arr2[i];
        }
        
        return result;
    }
}