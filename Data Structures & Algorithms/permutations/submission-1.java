class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        boolean[] isUsed = new boolean[size];
        solve(nums, 0, isUsed, new ArrayList<>());

        return res;
    }

    private void solve(int[] nums, int idx, boolean[] isUsed, List<Integer> perm) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < isUsed.length; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                perm.add(nums[i]);
                solve(nums, idx + 1, isUsed, perm);

                perm.remove(perm.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}
