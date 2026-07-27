class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;

        List<int[]> listIntervals = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            listIntervals.add(intervals[i]);
        }

        for(int i = 0; i < listIntervals.size() - 1; ++i) {
            int[] currentInterval = listIntervals.get(i);
            int[] nextInterval = listIntervals.get(i + 1);
            while (i < listIntervals.size() - 1 &&
                currentInterval[1] >= nextInterval[0]) {

                currentInterval[1] =
                    Math.max(currentInterval[1], nextInterval[1]);

                listIntervals.remove(i + 1);

                if (i < listIntervals.size() - 1) {
                    nextInterval = listIntervals.get(i + 1);
                }
            }
        }

        return listIntervals.toArray(new int[listIntervals.size()][]);
    }
}