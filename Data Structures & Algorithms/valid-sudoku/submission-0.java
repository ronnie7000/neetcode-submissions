class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //Check each row
        for(int row = 0; row < board.length; row++) {
            Set<Character> seen = new HashSet<>();

            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(!seen.add(board[row][col])) {
                    return false;
                }
            }
        }

        // Check each col
        for(int col = 0; col < board[0].length; col++) {
            Set<Character> seen = new HashSet<>();;

            for(int row = 0; row < board.length; row++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(!seen.add(board[row][col])) {
                    return false;
                }
            }
        }

        // Check each square
        for(int R = 0; R < board.length; R += 3) {
            for(int C = 0; C < board[0].length; C += 3) {
                Set<Character> seen = new HashSet<>();

                for(int row = R; row < R + 3; row++) {
                    for(int col = C; col < C + 3; col++) {
                        if(board[row][col] == '.') {
                            continue;
                        }
                        if(!seen.add(board[row][col])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
