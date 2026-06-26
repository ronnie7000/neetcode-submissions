class Solution {
    
    private static final int[] dirX = new int[] {-1, 0, 1, 0};
    private static final int[] dirY = new int[] {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int R = grid.length, C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int islands = 0;

        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                if(grid[row][col] == '1' && !visited[row][col]) {
                    dfs(grid, row, col, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for(int i = 0; i < dirX.length; i++) {
            int x = row + dirX[i];
            int y = col + dirY[i];

            if(isValid(grid, x, y) && grid[x][y] == '1' && !visited[x][y]) {
                dfs(grid, x, y, visited);
            }
        }
    }

    private boolean isValid(char[][] grid, int row, int col) {
        if(-1 < row && row < grid.length && -1 < col && col < grid[0].length) {
            return true;
        }
        return false;
    }
}
