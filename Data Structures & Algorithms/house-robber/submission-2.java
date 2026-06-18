class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return nums[n - 1];
        }
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = nums[n - 2];

        for(int i = n - 3; i > -1; i--) {
            dp[i] = Math.max(
                nums[i] + dp[i + 2],
                dp[i + 1]
            );
        }
        return Math.max(dp[0], dp[1]);
    }
}
