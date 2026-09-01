import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = -1, startY = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        
        // Initialize litter IDs to -1
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }
        
        // Locate start position and index the litter cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }
        
        // The binary state where all litter bits are flipped to 1
        int targetMask = (1 << litterCount) - 1;
        if (targetMask == 0) return 0; // Edge case: No litter in the classroom
        
        // bestEnergy[r][c][mask] stores the maximum energy recorded at that specific state
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        // Queue elements: {row, col, bitmask, current_energy, step_count}
        q.offer(new int[]{startX, startY, 0, energy, 0});
        bestEnergy[startX][startY][0] = energy;
        
        // Direction vectors for up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int e = curr[3];
            int steps = curr[4];
            
            // Explore all 4 adjacent directions
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // Check grid boundaries
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    char nextCell = classroom[nr].charAt(nc);
                    
                    if (nextCell == 'X') continue; // Cannot pass through obstacles
                    
                    int nextE = e - 1; // 1 energy cost per step
                    if (nextE < 0) continue; // Out of energy, invalid move
                    
                    int nextMask = mask;
                    
                    // If we step on litter, update our bitmask
                    if (nextCell == 'L') {
                        nextMask |= (1 << litterId[nr][nc]);
                    }
                    
                    // Check if we collected everything
                    if (nextMask == targetMask) return steps + 1;
                    
                    // If we step on a reset space, max out energy
                    if (nextCell == 'R') {
                        nextE = energy; 
                    }
                    
                    // Pruning: only add to queue if this path leaves us with more energy than before
                    if (nextE > bestEnergy[nr][nc][nextMask]) {
                        bestEnergy[nr][nc][nextMask] = nextE;
                        q.offer(new int[]{nr, nc, nextMask, nextE, steps + 1});
                    }
                }
            }
        }
        
        // Impossible to clean the entire classroom
        return -1;
    }
}