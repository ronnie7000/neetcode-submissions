class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(n, 0, 0, new StringBuilder());
        return res;
    }

    private void solve(int size, int open, int close, StringBuilder sb) {
        if(close > open || open > size) {
            return;
        }

        if(close == size) {
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        solve(size, open + 1, close, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        solve(size, open, close + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
