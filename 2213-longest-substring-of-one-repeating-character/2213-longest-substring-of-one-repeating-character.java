class Solution {
    
    // Structure to hold the state of each segment tree node
    class Node {
        int maxLen;
        int preLen;
        int sufLen;
        char preChar;
        char sufChar;
        int size;
    }
    
    Node[] tree;
    
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        tree = new Node[4 * n];
        char[] arr = s.toCharArray();
        
        // Build the initial segment tree
        build(1, 0, n - 1, arr);
        
        int k = queryIndices.length;
        int[] ans = new int[k];
        
        // Process each query
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            // The root node always contains the max length for the whole string
            ans[i] = tree[1].maxLen;
        }
        
        return ans;
    }
    
    private void build(int node, int start, int end, char[] arr) {
        if (start == end) {
            tree[node] = new Node();
            tree[node].maxLen = 1;
            tree[node].preLen = 1;
            tree[node].sufLen = 1;
            tree[node].preChar = arr[start];
            tree[node].sufChar = arr[start];
            tree[node].size = 1;
            return;
        }
        
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, arr);
        build(2 * node + 1, mid + 1, end, arr);
        
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    
    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node].preChar = c;
            tree[node].sufChar = c;
            return;
        }
        
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    
    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.size = left.size + right.size;
        res.preChar = left.preChar;
        res.sufChar = right.sufChar;
        
        // Calculate prefix length
        res.preLen = left.preLen;
        if (left.preLen == left.size && left.sufChar == right.preChar) {
            res.preLen = left.size + right.preLen;
        }
        
        // Calculate suffix length
        res.sufLen = right.sufLen;
        if (right.sufLen == right.size && left.sufChar == right.preChar) {
            res.sufLen = right.size + left.sufLen;
        }
        
        // Calculate max length in this combined segment
        res.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.sufChar == right.preChar) {
            res.maxLen = Math.max(res.maxLen, left.sufLen + right.preLen);
        }
        
        return res;
    }
}