class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxSize = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if(set.contains(ch)) {
                while(left < right && s.charAt(left) != ch) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxSize = Math.max(maxSize, set.size());
        }
        return maxSize;
    }
}
