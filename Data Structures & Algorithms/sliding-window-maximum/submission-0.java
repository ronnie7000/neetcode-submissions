class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        int left = 0;
        for(int right = k-1; right < nums.length; right++) {
            ans[idx++] = getMax(nums, left, right);
            left++;
        }
        return ans;
    }

    private int getMax(int[] arr, int left, int right) {
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
