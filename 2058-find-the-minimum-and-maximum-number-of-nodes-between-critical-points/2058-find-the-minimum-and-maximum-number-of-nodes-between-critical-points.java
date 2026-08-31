/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};
        
        // A critical point requires at least 3 nodes (prev, curr, next)
        if (head == null || head.next == null || head.next.next == null) {
            return result;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int position = 1; // 1-based index for positions

        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            ListNode nextNode = curr.next;

            // Check if the current node is a local maxima or minima
            if ((curr.val > prev.val && curr.val > nextNode.val) || 
                (curr.val < prev.val && curr.val < nextNode.val)) {
                
                if (firstCritical == -1) {
                    // First critical point found
                    firstCritical = position;
                } else {
                    // Subsequent critical points: calculate min distance
                    minDistance = Math.min(minDistance, position - lastCritical);
                }
                // Update the last seen critical point
                lastCritical = position;
            }

            // Move pointers forward
            prev = curr;
            curr = nextNode;
            position++;
        }

        // If we found at least 2 critical points, update the result array
        if (minDistance != Integer.MAX_VALUE) {
            result[0] = minDistance;
            result[1] = lastCritical - firstCritical;
        }

        return result;
    }
}