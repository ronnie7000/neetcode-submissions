class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        solve(s, 0, new ArrayList<>());
        return res;
    }

    private void solve(String str, int start, List<String> curr) {
        if(start == str.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < str.length(); i++) {
            if(isPalindrome(str, start, i)) {
                curr.add(str.substring(start, i + 1));
                solve(str, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int left, int right) {
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
