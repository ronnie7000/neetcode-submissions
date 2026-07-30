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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) {
            return 0;
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int rooms = 0;
        Queue<Integer> meetings = new PriorityQueue<>();

        for(Interval interval : intervals) {
            int startTime = interval.start;

            while(!meetings.isEmpty() && meetings.peek() <= startTime) {
                meetings.poll();
            }
            meetings.add(interval.end);
            rooms = Math.max(rooms, meetings.size());
        }
        return rooms;
    }
}
