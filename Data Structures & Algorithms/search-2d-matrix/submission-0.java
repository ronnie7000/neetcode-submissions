class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length, C = matrix[0].length;
        int r = 0, c = C - 1;

        while(r < R && c > -1) {
            int val = matrix[r][c];

            if(val == target) {
                return true;
            } else if (val < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}
