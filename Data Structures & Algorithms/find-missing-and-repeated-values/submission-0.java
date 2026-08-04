class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = 1L * n * n;

        long expectedSum = N * (N + 1) / 2;
        long expectedSquareSum = N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                int val = grid[row][col];
                actualSum += val;
                actualSquareSum += 1L * val * val;
            }
        }

        long diff = actualSum - expectedSum;
        long squareDiff = actualSquareSum - expectedSquareSum;

        long sum = squareDiff / diff;

        int repeated = (int)((diff + sum) / 2);
        int missing = (int)(sum - repeated);
        
        return new int[] {repeated, missing};
    }
}