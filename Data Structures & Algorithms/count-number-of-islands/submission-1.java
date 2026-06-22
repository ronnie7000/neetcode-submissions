class Solution {
    private int[] dirX = new int[] {-1, 0, 1, 0};
    private int[] dirY = new int[] {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int R = grid.length, C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int island = 0;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == '1' && !visited[r][c]) {
                    solve(grid, r, c, visited);
                    island++;
                }
            }
        }
        return island;
    }

    private void solve(char[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for(int i = 0; i < dirX.length; i++) {
            int x = r + dirX[i];
            int y = c + dirY[i];

            if(isValidCoordinate(grid, x, y) && grid[x][y] == '1' && !visited[x][y]) {
                solve(grid, x, y, visited);
            }
        }
    }

    private boolean isValidCoordinate(char[][] grid, int r, int c) {
        if(-1 < r && r < grid.length && -1 < c && c < grid[0].length) {
            return true;
        }
        return false;
    }
}
