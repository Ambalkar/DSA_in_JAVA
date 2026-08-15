class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        // Array to store the frequency of each lowercase letter in the current window
        int[] freq = new int[26]; 
        
        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the window
            char rightChar = s.charAt(right);
            freq[rightChar - 'a']++;
            
            // If the character appears more than twice, shrink the window from the left
            while (freq[rightChar - 'a'] > 2) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }
            
            // Update the maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}