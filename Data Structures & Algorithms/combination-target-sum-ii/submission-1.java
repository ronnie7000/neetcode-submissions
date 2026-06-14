class Solution {
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        generateCombinations(candidates, new ArrayList<>(), target, 0, 0);

        return res;
    }

    private void generateCombinations(int[] nums, List<Integer> comb, int target, int idx, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(comb));
            return;
        } else if (idx == nums.length) {
            return;
        }


        if(sum + nums[idx] > target) {
            int nextIdx = idx + 1;
            while(nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
                nextIdx++;
            }

            generateCombinations(nums, comb, target, nextIdx, sum);
        } else {
            sum += nums[idx];
            comb.add(nums[idx]);
            generateCombinations(nums, comb, target, idx + 1, sum);

            sum -= nums[idx];
            comb.remove(comb.size() - 1);

            int nextIdx = idx + 1;
            while(nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
                nextIdx++;
            }

            generateCombinations(nums, comb, target, nextIdx, sum);
        }
    }
}
