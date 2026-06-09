class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long ans = 0;
        long top = 1, end = 1;

        for(int pile : piles) {
            end = Math.max(end, pile);
        }

        while(top <= end) {
            long mid = top + (end - top) / 2;
            long neededHours = getNeededHours(piles, mid);
            
            if(neededHours <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return (int) ans;
    }

    private long getNeededHours(int[] piles, long rate) {
        long hours = 0;

        for(int pile : piles) {
            hours += pile / rate;
            if(pile % rate != 0) {
                hours++;
            }
        }
        return hours;
    }
}
