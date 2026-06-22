class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList<>());
        return subsets;
    }

    private void solve(int[] nums, int idx, List<Integer> subset) {
        if(idx == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        solve(nums, idx + 1, subset);

        subset.remove(subset.size() - 1);
        solve(nums, idx + 1, subset);
    }
}
