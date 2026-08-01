class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            if(nums[left] != val) {
                left++;
            } else if (nums[right] == val) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}