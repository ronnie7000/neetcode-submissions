class Solution {
    
    List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        generateSubsets(nums, new ArrayList<>(), 0);

        return subsets;
    }

    private void generateSubsets(int[] nums, List<Integer> subset, int idx) {
        if(idx == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        int nextIdx = idx + 1;

        while(nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
            nextIdx++;
        }

        for(int totalFreq = 0; totalFreq <= (nextIdx - idx); totalFreq++) {

            for(int count = 0; count < totalFreq; count++) {
                subset.add(nums[idx]);
            }

            generateSubsets(nums, subset, nextIdx);

            for(int count = 0; count < totalFreq; count++) {
                subset.remove(subset.size() - 1);
            }
        }
    }
}
