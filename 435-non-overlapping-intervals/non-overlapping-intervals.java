class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int removalCount = 0;

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); // sort by starting interval
        int[] prev = intervals[0];

        for(int i = 1; i < n; ++i) {
            int[] curr = intervals[i];

            int prevEnd = prev[1];
            int currStart = curr[0];

            if(currStart < prevEnd) {
                removalCount++;
            } else {
                prev = curr;
            }
        }

        return removalCount;
    }
}