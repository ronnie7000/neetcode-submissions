class Solution {
    private List<List<Integer>> subsets = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(nums, new ArrayList<>(), 0);

        return subsets;    
    }

    private void generateSubsets(int[] nums, List<Integer> subset, int idx) {
        if(idx == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        generateSubsets(nums, subset, idx + 1);

        subset.remove(subset.size() - 1);
        generateSubsets(nums, subset, idx + 1);
    }
}
