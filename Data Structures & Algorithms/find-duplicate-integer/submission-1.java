class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;

            if(nums[val] < 0) {
                return val + 1;
            }

            nums[val] = Math.abs(nums[val]) * -1;
        }
        return 0;
    }
}
