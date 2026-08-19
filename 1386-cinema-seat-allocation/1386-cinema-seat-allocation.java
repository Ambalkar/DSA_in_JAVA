import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map to store row number -> bitmask of reserved seats
        Map<Integer, Integer> rowToReservedMask = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Set the bit corresponding to the seat number
            rowToReservedMask.put(row, rowToReservedMask.getOrDefault(row, 0) | (1 << col));
        }
        
        // Completely empty rows can hold 2 families each
        int maxFamilies = (n - rowToReservedMask.size()) * 2;
        
        // Bitmasks for the allowed 4-person groups
        int leftMask = 60;   // seats 2, 3, 4, 5 (0000111100 in binary)
        int rightMask = 960; // seats 6, 7, 8, 9 (1111000000 in binary)
        int midMask = 240;   // seats 4, 5, 6, 7 (0011110000 in binary)
        
        for (int mask : rowToReservedMask.values()) {
            boolean leftFree = (mask & leftMask) == 0;
            boolean rightFree = (mask & rightMask) == 0;
            boolean midFree = (mask & midMask) == 0;
            
            if (leftFree && rightFree) {
                // We can fit two groups
                maxFamilies += 2;
            } else if (leftFree || rightFree || midFree) {
                // We can fit exactly one group
                maxFamilies += 1;
            }
            // If none of the blocks are free, we fit 0 groups, so add nothing.
        }
        
        return maxFamilies;
    }
}