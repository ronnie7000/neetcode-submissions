class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve("", 0, 0, n);

        return res;    
    }

    private void solve(String str, int open, int close, int size) {
        if(close > open || open > size) {
            return;
        }
        if(close == size) {
            res.add(str);
            return;
        }

        solve(str + '(', open + 1, close, size);
        solve(str + ')', open, close + 1, size);
    }
}
