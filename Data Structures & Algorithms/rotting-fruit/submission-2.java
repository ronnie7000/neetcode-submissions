class Solution {

    private static final int[] dirX = new int[] {-1, 0, 1, 0};
    private static final int[] dirY = new int[] {0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int maxTime = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                if(grid[row][col] == 2) {
                    queue.add(new int[] {0, row, col});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] fruit = queue.poll();
            maxTime = Math.max(maxTime, fruit[0]);

            for(int i = 0; i < dirX.length; i++) {
                int x = fruit[1] + dirX[i];
                int y = fruit[2] + dirY[i];

                if(isValid(grid, x, y) && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    queue.add(new int[] {fruit[0] + 1, x, y});
                }
            }
        }

        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                if(grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return maxTime;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        if(-1 < row && row < grid.length && -1 < col && col < grid[0].length) {
            return true;
        }
        return false;
    }
}
