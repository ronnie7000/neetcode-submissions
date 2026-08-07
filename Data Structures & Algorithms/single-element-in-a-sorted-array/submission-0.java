class Solution {
    public int singleNonDuplicate(int[] nums) {
        int top = 0, end = nums.length - 1;

        while(top <= end) {
            int mid = top + (end - top) / 2;

            int prev = getSafe(nums, mid - 1);
            int curr = getSafe(nums, mid);
            int next = getSafe(nums, mid + 1);

            if(prev != curr && curr != next) {
                return curr;
            }

            if(prev == curr) {
                mid--;
            }

            if(mid % 2 == 0) {
                top = mid + 2;
            } else {
                end = mid - 1;
            }
        }

        return nums[0];
    }

    private int getSafe(int[] nums, int pos) {
        if(-1 < pos && pos < nums.length) {
            return nums[pos];
        }

        return Integer.MIN_VALUE;
    }
}