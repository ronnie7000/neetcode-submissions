class Solution {
    public int search(int[] nums, int target) {
        int top = 0, end = nums.length - 1;

        while(top <= end) {
            int mid = top + (end - top) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                top = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;   
    }
}
