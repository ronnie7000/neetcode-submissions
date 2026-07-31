class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - nums[i];

            if(map.containsKey(y)) {
                ans[0] = map.get(y);
                ans[1] = i;
                break;
            }
            map.put(x, map.getOrDefault(x, i));
        }

        return ans;
    }
}
