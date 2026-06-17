class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(n, 0, 0, "");
        return res;
    }

    private void solve(int size, int open, int close, String str) {
        if(close > open || open > size) {
            return;
        }

        if(close == size) {
            res.add(str);
            return;
        }

        solve(size, open + 1, close, str + '(');
        solve(size, open, close + 1, str + ')');
    }
}
