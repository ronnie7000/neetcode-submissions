class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            // Current interval is before new interval
            if(interval[1] < start) {
                intervalsList.add(interval);
            } 
            // Current interval is after new interval
            else if (end < interval[0]) {
                intervalsList.add(new int[]{start, end});

                // Add remaining intervals
                for(int j = i; j < intervals.length; j++) {
                    intervalsList.add(intervals[j]);
                }
                return intervalsList.toArray(new int[intervalsList.size()][]);
            } 
            // Current interval is merging with new interval
            else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        intervalsList.add(new int[] {start, end});

        return intervalsList.toArray(new int[intervalsList.size()][]);
    }
}
