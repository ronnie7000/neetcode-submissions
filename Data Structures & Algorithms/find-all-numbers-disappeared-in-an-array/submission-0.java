class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for(int num : nums) {
            seen.add(num);
        }

        for(int i = 1; i <= nums.length; i++) {
            if(!seen.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}