class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            int onesCount = 0;
            
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    onesCount++;
                }
                
                // When we hit exactly k ones, we evaluate the substring
                if (onesCount == k) {
                    String currentSub = s.substring(i, j + 1);
                    
                    if (currentSub.length() < minLen) {
                        // Found a strictly shorter valid substring
                        minLen = currentSub.length();
                        ans = currentSub;
                    } else if (currentSub.length() == minLen) {
                        // If lengths are equal, pick the lexicographically smaller one
                        if (currentSub.compareTo(ans) < 0) {
                            ans = currentSub;
                        }
                    }
                    // Break early because any longer substring starting at 'i' 
                    // will have a length greater than the one we just found.
                    break; 
                }
            }
        }
        
        return ans;
    }
}