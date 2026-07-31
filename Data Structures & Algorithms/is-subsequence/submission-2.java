class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }
        if(s.length() > t.length()) {
            return false;
        }

        int x = 0, y = 0;

        while(x < s.length() && y < t.length()) {
            if(s.charAt(x) == t.charAt(y)) {
                x++;
            }
            y++;
        }

        return x == s.length();
    }
}