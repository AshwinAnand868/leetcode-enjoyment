class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();

        boolean inserted = false;

        for (int i = 0; i < intervals.length; i++) {
            if (!inserted && intervals[i][0] > newInterval[0]) {
                newIntervals.add(newInterval);
                inserted = true;
            }

            newIntervals.add(intervals[i]);
        }

        if (!inserted) {
            newIntervals.add(newInterval);
        }

        List<int[]> merged = new ArrayList<>();
        int[] last = newIntervals.get(0);

        for (int i = 1; i < newIntervals.size(); i++) {
            int currStart = newIntervals.get(i)[0];
            int currEnd = newIntervals.get(i)[1];

            int lastEnd = last[1];

            // overlap
            if (currStart <= lastEnd) {
                last[1] = Math.max(lastEnd, currEnd);
            }
            else {
                merged.add(last);
                last = newIntervals.get(i);
            }
        }

        merged.add(last);

        return merged.toArray(new int[merged.size()][]);
    }
}
