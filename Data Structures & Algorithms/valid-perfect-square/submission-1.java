class Solution {
    public boolean isPerfectSquare(int num) {
        int top = 1, end = num;

        while(top <= end) {
            int mid = top + (end - top) / 2;
            long square = (long) mid * mid;

            if(square == num) {
                return true;
            } else if (square < num) {
                top = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}