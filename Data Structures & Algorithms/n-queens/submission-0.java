class Solution {
    
    List<List<String>> res = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        solve(board, 0);
        return res;    
    }

    private void solve(char[][] board, int r) {
        if(r == board.length) {
            res.add(convertToString(board));
            return;
        }

        for(int c = 0; c < board[0].length; c++) {
            if(col.contains(c) || 
               diag.contains(r - c) || 
               antiDiag.contains(r + c)) {
                continue;
            }

            board[r][c] = 'Q';
            col.add(c);
            diag.add(r - c);
            antiDiag.add(r + c);

            solve(board, r + 1);

            board[r][c] = '.';
            col.remove(c);
            diag.remove(r - c);
            antiDiag.remove(r + c);
        }
    }

    private List<String> convertToString(char[][] board) {
        List<String> list = new ArrayList<>();
        for(int r = 0; r < board.length; r++) {
            StringBuilder sb = new StringBuilder();

            for(int c = 0; c < board[0].length; c++) {
                sb.append(board[r][c]);
            }

            list.add(sb.toString());
        }
        return list;
    }
}
