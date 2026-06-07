class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            if(set.contains(num - 1)) {
                continue;
            }
            
            int count = 0;
            while(set.contains(num + count)) {
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
