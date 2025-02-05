class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
                int seconds = 0;
        int n = timeSeries.length;
        int oldEnd = -1;
        int oldStart = -1;

        for (int i = 0; i < n; ++i) {
            int newStart = timeSeries[i];
            int newEnd = newStart + duration - 1;

            if (oldStart <= newStart && newStart <= oldEnd) {
                seconds += newEnd - oldEnd;
            } else {
                seconds += newEnd - newStart + 1;
            }

            oldStart = newStart;
            oldEnd = newEnd;
        }

        return seconds;
    }
}