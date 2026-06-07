class Solution {
    public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int left = 0, right = nums.length - 1;

            for(int i = 0; i < nums.length; i++) {
                int x = nums[i];
                int y = target - x;

                if(map.containsKey(y)) {
                    left = map.get(y);
                    right = i;
                    break;
                }
                map.put(x, map.getOrDefault(x, i));
            }

            return new int[] {left, right};

    }
}
