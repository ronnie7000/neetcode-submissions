class Solution {
    int[] dirX = new int[] {-1, 0, 0, 1};
    int[] dirY = new int[] {0, -1, 1, 0};

    public int maxAreaOfIsland(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int maxArea = 0;

        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                if(grid[row][col] == 1 && !visited[row][col]) {
                    int area = dfs(grid, row, col, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid,int row, int col, boolean[][] visited) {
        // if(grid[row][col] == 0) {
        //     return 0;
        // }
        visited[row][col] = true;
        int area = 1;

        for(int i = 0; i < dirX.length; i++) {
            int x = row + dirX[i];
            int y = col + dirY[i];

            if(isValidCoordinate(grid, x, y) && grid[x][y] == 1 && !visited[x][y]) {
                area += dfs(grid, x, y, visited);
            }
        }
        return area;
    }

    private boolean isValidCoordinate(int[][] grid, int row, int col) {
        if(-1 < row && row < grid.length && -1 < col && col < grid[0].length) {
            return true;
        }
        return false;
    }
}
