class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>());
        return res;   
    }

    private void solve(int[] nums, int start, int sum, List<Integer> comb) {
        if(sum == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if(sum < 0) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            
            if(i > start && nums[i - 1] == nums[i]) {
                continue;
            }

            sum -= nums[i];
            comb.add(nums[i]);
            solve(nums, i + 1, sum, comb);

            comb.remove(comb.size() - 1);
            sum += nums[i];
        }
    }
}
