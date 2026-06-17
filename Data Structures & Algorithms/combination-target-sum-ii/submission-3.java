class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>());
        return res;    
    }
    
    private void solve(int[] nums, int start, int sum, List<Integer> curr) {
        if(sum == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum < 0) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            sum -= nums[i];
            curr.add(nums[i]);
            solve(nums, i + 1, sum, curr);

            sum += nums[i];
            curr.remove(curr.size() - 1);
        }
    }
}
