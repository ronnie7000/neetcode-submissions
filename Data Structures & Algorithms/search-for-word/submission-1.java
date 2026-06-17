class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(solve(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, int row, int col, String word, int idx) {
        if(idx == word.length()) {
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if(word.charAt(idx) != board[row][col]) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean res =  solve(board, row + 1, col, word, idx + 1) ||
                       solve(board, row - 1, col, word, idx + 1) ||
                       solve(board, row, col + 1, word, idx + 1) ||
                       solve(board, row, col - 1, word, idx + 1);
        
        board[row][col] = temp;
        return res;
    }
}
