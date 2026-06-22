class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        solve(nums, target, 0, new ArrayList<>());
        return res;
    }

    private void solve(int[] nums, int sum, int idx, List<Integer> comb) {
        if(sum == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if(sum < 0 || idx == nums.length) {
            return;
        }

        for(int start = idx; start < nums.length; start++) {
            sum -= nums[start];
            comb.add(nums[start]);
            solve(nums, sum, start, comb);

            comb.remove(comb.size() - 1);
            sum += nums[start];
        }
    }
}
