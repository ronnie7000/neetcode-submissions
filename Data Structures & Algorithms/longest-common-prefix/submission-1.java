class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        int idx = 0;
        while(idx < strs[0].length()) {
            for(int i = 1; i < strs.length; i++) {
                if(strs[0].charAt(idx) != strs[i].charAt(idx)) {
                    return strs[0].substring(0, idx);
                }
            }
            idx++;
        }

        return strs[0];
    }
}