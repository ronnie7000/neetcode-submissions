class Solution {
    List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return subsets;
    }

    private void solve(int[] nums, int idx, List<Integer> subset) {
        if(idx == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        int nextIdx = idx + 1;
        while(nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
            nextIdx++;
        }

        for(int totalCount = 0; totalCount <= (nextIdx - idx); totalCount++) {
            for(int count = 0; count < totalCount; count++) {
                subset.add(nums[idx]);
            }

            solve(nums, nextIdx, subset);

            for(int count = 0; count < totalCount; count++) {
                subset.remove(subset.size() - 1);
            }
        }
    }
}
