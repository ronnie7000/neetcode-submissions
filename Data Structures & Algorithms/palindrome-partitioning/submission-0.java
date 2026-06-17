class Solution {
    
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        solve(s, 0, new ArrayList<>());
        return res;
    }

    private void solve(String s, int start, List<String> currList) {
        if(start == s.length()) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                currList.add(s.substring(start, end + 1));
                solve(s, end + 1, currList);
                currList.remove(currList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
