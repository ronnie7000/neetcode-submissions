class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return nums[n - 1];
        }
        int a = nums[0], b = Math.max(a, nums[1]), c = Math.max(a, b);
        for(int i = 2; i < n; i++) {
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
