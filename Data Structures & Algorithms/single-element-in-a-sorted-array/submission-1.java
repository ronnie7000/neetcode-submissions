class Solution {
    public int singleNonDuplicate(int[] nums) {
        int top = 0, end = nums.length - 1;

        while(top < end) {
            int mid = top + (end - top) / 2;

            if(mid % 2 == 1) {
                mid--;
            }

            if(nums[mid] == nums[mid + 1]) {
                top = mid + 2;
            } else {
                end = mid;
            }
        }

        return nums[top];
    }
}