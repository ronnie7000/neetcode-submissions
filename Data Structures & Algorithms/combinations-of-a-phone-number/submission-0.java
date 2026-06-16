class Solution {

    private char[][] dict = new char[][] {
        {'0'}, {'1'}, {'a', 'b', 'c'},
        {'d', 'e', 'f'}, {'g', 'h', 'i'},
        {'j', 'k', 'l'}, {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return res;
        }
        
        solve(digits, 0, "");

        return res;
    }

    private void solve(String digits, int idx, String comb) {
        if(idx == digits.length()) {
            res.add(comb);
            return;
        }

        for(char ch : dict[Character.getNumericValue(digits.charAt(idx))]) {
            solve(digits, idx + 1, comb + ch);
        }
    }


}
