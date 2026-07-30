/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int prevEnd = 0;
        for(Interval interval : intervals) {
            if(prevEnd > interval.start) {
                return false;
            }
            prevEnd = interval.end;
        }
        return true;
    }
}
