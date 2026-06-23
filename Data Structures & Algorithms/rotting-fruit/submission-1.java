class Solution {
    int[] dirX = new int[] {-1, 0, 1, 0};
    int[] dirY = new int[] {0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int maxTime = 0;

        Queue<int[]> queue = new LinkedList<>();
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 2) {
                    queue.add(new int[] {0, r, c});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] fruit = queue.poll();
            maxTime = Math.max(maxTime, fruit[0]);

            for(int i = 0; i < dirX.length; i++) {
                int x = fruit[1] + dirX[i];
                int y = fruit[2] + dirY[i];

                if(isValidCoordinate(grid, x, y) && grid[x][y] == 1) {
                    queue.add(new int[] {fruit[0] + 1, x, y});
                    grid[x][y] = 2;
                }
            }
        }

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 1) {
                    return -1;
                }
            }
        }
        return maxTime;
    }

    private boolean isValidCoordinate(int[][] grid, int r, int c) {
        if(-1 < r && r < grid.length && -1 < c && c < grid[0].length) {
            return true;
        }
        return false;
    }
}
