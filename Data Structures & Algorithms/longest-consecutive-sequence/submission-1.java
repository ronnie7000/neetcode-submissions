class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            if(!set.contains(num - 1)) {
                continue;
            }
            int value = num;
            int size = 1;
            while(set.contains(value + 1)) {
                value++;
                size++;
            }
            ans = Math.max(ans, size);
        }

        return ans + 1;
    }
}
