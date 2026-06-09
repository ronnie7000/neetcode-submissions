class Solution {
    public int search(int[] nums, int target) {
        int top = 0, end = nums.length - 1, last = nums[end];
        int pivot = getPivot(nums);
        if(target <= last) {
            top = pivot;
        } else {
            end = pivot - 1;
        }

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

    private int getPivot(int[] nums) {
        int top = 0, end = nums.length - 1, last = nums[end];
        int ans = 0;
        while(top <= end) {
            int mid = top + (end - top) / 2;

            if(nums[mid] > last) {
                top = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
