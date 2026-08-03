class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int maxIncreasingCount = 1, maxDecreasingCount = 1, increasingCount = 1, decreasingCount = 1;

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];

            if(prev < curr) {
                increasingCount++;
                maxIncreasingCount = Math.max(maxIncreasingCount, increasingCount);
                decreasingCount = 1;
            } else if(prev > curr){
                decreasingCount++;
                maxDecreasingCount = Math.max(maxDecreasingCount, decreasingCount);
                increasingCount = 1;
            } else {
                increasingCount = 1;
                decreasingCount = 1;
            }
        }

        return Math.max(maxIncreasingCount, maxDecreasingCount);
    }
}