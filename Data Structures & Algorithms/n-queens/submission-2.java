class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> diagSet = new HashSet<>();
    Set<Integer> antiDiagSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(board, 0);
        return res;
    }

    private void solve(char[][] board, int row) {
        if(row == board.length) {
            res.add(convertToString(board));
            return;
        }
        
        for(int col = 0; col < board[0].length; col++) {
            if(colSet.contains(col) || diagSet.contains(row - col) || antiDiagSet.contains(row + col)) {
                continue;
            }

            board[row][col] = 'Q';
            colSet.add(col);
            diagSet.add(row - col);
            antiDiagSet.add(row + col);

            solve(board, row + 1);

            board[row][col] = '.';
            colSet.remove(col);
            diagSet.remove(row - col);
            antiDiagSet.remove(row + col);
        }
    }

    private List<String> convertToString(char[][] board) {
        List<String> list = new ArrayList<>();
        for(char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
