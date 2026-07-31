class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length, idx = 0;
        while(idx < strs[0].length()) {
            char ch = strs[0].charAt(idx);

            for(int i = 1; i < length; i++) {
                if(idx == strs[i].length() || ch != strs[i].charAt(idx)) {
                    return strs[0].substring(0, idx);
                }
            }
            idx++;
        }

        return strs[0];
    }
}