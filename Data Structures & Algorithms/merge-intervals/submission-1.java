class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> intervalsList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if(end < interval[0]) {
                intervalsList.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        intervalsList.add(new int[] {start, end});

        return intervalsList.toArray(new int[0][]);
    }
}
