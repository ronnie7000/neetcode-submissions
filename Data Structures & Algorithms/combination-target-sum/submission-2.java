class Solution {
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        solve(nums, 0, target, new ArrayList<>());
        return res;
    }

    private void solve(int[] nums, int start, int sum, List<Integer> curr) {
        if(sum == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum < 0 || start == nums.length) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            sum -= nums[i];
            curr.add(nums[i]);
            solve(nums, i, sum, curr);

            curr.remove(curr.size() - 1);
            sum += nums[i];
        }
    } 
}
