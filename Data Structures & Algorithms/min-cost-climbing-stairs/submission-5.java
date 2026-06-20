class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        if(n < 2) {
            return n;
        }

        int a = 0, b = 0, c = -1;

        for(int i = 2; i <= n; i++) {
            c = Math.min(
                a + cost[i - 2],
                b + cost[i - 1]
            );
            a = b;
            b = c;
        }

        return c;
    }
}
