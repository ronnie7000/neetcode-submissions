class Solution {
    
    List<List<Integer>> permutations = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        Arrays.fill(isUsed, false);

        generatePermutations(nums, new ArrayList<>(), isUsed, 0);

        return permutations;
    }

    private void generatePermutations(int[] nums, List<Integer> perm, boolean[] isUsed, int idx) {
        if(idx == nums.length) {
            permutations.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < isUsed.length; i++) {
            if(!isUsed[i]) {
                perm.add(nums[i]);
                isUsed[i] = true;
                generatePermutations(nums, perm, isUsed, idx + 1);

                perm.remove(perm.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}
