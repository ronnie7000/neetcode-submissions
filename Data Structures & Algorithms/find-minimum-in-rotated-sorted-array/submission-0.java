class Solution {
    public int findMin(int[] nums) {
        int top = 0, end = nums.length - 1, last = nums[end];
        int ans = 0;
        while(top <= end) {
            int mid = top + (end - top) / 2;

            if(nums[mid] > last) {
                top = mid + 1;
            } else {
                ans = nums[mid];
                end = mid - 1;
            }
        }
        return ans;        
    }
}
