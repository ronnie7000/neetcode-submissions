class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        generateCombinations(nums, new ArrayList<>(), target, 0, 0);

        return res;
    }

    private void generateCombinations(int[] nums, List<Integer> comb, int target, int idx, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(comb));
            return;
        }
        
        if(idx == nums.length) {
            return;
        }

        if(sum + nums[idx] > target) {
            generateCombinations(nums, comb, target, idx + 1, sum);
        } else {
            sum += nums[idx];
            comb.add(nums[idx]);
            generateCombinations(nums, comb, target, idx, sum);

            sum -= nums[idx];
            comb.remove(comb.size() - 1);
            generateCombinations(nums, comb, target, idx + 1, sum);
        }
    }
}
