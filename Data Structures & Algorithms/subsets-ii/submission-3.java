class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return res;
    }

    private void solve(int[] nums, int idx, List<Integer> sub) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        int nextIdx = idx + 1;
        while(nextIdx < nums.length && nums[idx] == nums[nextIdx]) {
            nextIdx++;
        }

        for(int totalCount = 0; totalCount <= (nextIdx - idx); totalCount++) {
            for(int count = 0; count < totalCount; count++) {
                sub.add(nums[idx]);
            }
            solve(nums, nextIdx, sub);

            for(int count = 0; count < totalCount; count++) {
                sub.remove(sub.size() - 1);
            }
        }
    }
}
