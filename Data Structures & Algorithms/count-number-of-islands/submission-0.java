class Solution {
    int[] dirX = new int[] {-1, 0, 0, 1};
    int[] dirY = new int[] {0, -1, 1, 0};

    public int numIslands(char[][] grid) {
        int R = grid.length, C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int island = 0;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == '1' &&
                    !visited[r][c]) {
                    dfs(grid, r, c, visited);
                    island++;
                }
            }
        }
        return island;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for(int i = 0; i < dirX.length; i++) {
            int x = row + dirX[i];
            int y = col + dirY[i];

            if(isValidCoordinate(grid, x, y) &&
               grid[x][y] == '1' &&
               !visited[x][y]) {
                dfs(grid, x, y, visited);
            }
        }
    }

    private boolean isValidCoordinate(char[][] grid, int x, int y) {
        if(-1 < x && x < grid.length && -1 < y && y < grid[0].length) {
            return true;
        }
        return false;
    }
}
