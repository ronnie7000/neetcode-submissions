class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;

        for(int i = 0; i < nums.length; i++) {
            int prev = getSafe(nums, i -1);
            int curr = getSafe(nums, i);

            if(prev < curr) {
                sum += curr;
                maxSum = Math.max(maxSum, sum);
            } else {
                sum = curr;
            }
        }

        return maxSum;
    }

    private int getSafe(int[] arr, int pos) {
        if(-1 < pos && pos < arr.length) {
            return arr[pos];
        }
        return 0;
    }
}