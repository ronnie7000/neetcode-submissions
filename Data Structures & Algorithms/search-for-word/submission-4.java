class Solution {
    public boolean exist(char[][] board, String word) {
        int R = board.length, C = board[0].length;

        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                if(solve(board, row, col, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, int row, int col, int idx, String word) {
        if(idx == word.length()) {
            return true;
        }

        if(row < 0 || board.length <= row || col < 0 || board[0].length <= col) {
            return false;
        }

        char ch = board[row][col];
        
        if(ch != word.charAt(idx)) {
            return false;
        }

        board[row][col] = '#';

        boolean res = solve(board, row + 1, col, idx + 1, word) ||
                      solve(board, row - 1, col, idx + 1, word) ||
                      solve(board, row, col + 1, idx + 1, word) ||
                      solve(board, row, col - 1, idx + 1, word);
        
        board[row][col] = ch;
        return res;
    }
}
