class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0, c = -1;

        for(int i = 2; i <= cost.length; i++) {
            c = Math.min(b + cost[i - 1], a + cost[i - 2]);
            a = b;
            b = c;
        }
        return c;
    }
}
