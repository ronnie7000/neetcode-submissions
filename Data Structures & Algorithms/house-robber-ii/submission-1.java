class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return nums[n - 1];
        }
        int x = solve(nums, 0, n - 2);
        int y = solve(nums, 1, n - 1);
        return Math.max(x, y);
    }

    private int solve(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        }
        int a = nums[start], b = Math.max(a, nums[start + 1]), c = Math.max(a, b);

        for(int i = start + 2; i <= end; i++) {
            c = Math.max(
                nums[i] + a,
                b
            );
            a = b;
            b = c;
        }
        return c;    
    }

}
