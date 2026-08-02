class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0, candidate = 0;

        for(int i = 0; i < nums.length; i++) {
            if(vote == 0) {
                candidate = nums[i];
            }
            
            if(nums[i] == candidate) {
                vote++;
            } else {
                vote--;
            }
        }
        return candidate;
    }
}