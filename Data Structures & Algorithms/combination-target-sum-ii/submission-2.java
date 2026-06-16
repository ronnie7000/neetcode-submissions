class Solution {
    
    List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        generateCombinations(candidates, target, 0, new ArrayList<>(), 0);

        return combinations;
    }

    private void generateCombinations(int[] nums, int target, int sum, List<Integer> comb, int idx) {
        if(sum == target) {
            combinations.add(new ArrayList<>(comb));
            return;
        }

        if(idx == nums.length) {
            return;
        }

        if(sum + nums[idx] > target) {
            int nextIdx = idx + 1;

            while(nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
                nextIdx++;
            }

            generateCombinations(nums, target, sum, comb, nextIdx);
        } else {
            sum += nums[idx];
            comb.add(nums[idx]);

            generateCombinations(nums, target, sum, comb, idx + 1);

            sum -= nums[idx];
            comb.remove(comb.size() - 1);

            int nextIdx = idx + 1;

            while(nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
                nextIdx++;
            }

            generateCombinations(nums, target, sum, comb, nextIdx);
        }
    }
}
