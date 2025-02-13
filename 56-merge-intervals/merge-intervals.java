class Solution {
    public int[][] merge(int[][] intervals) {
       List<int[]> answer = new ArrayList<>();

       Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
       answer.add(intervals[0]);
       for(int[] interval : intervals) {
        if(answer.get(answer.size() - 1)[1] < interval[0]) {
            answer.add(interval);
        } else {
            answer.get(answer.size() - 1)[1] = Math.max(answer.get(answer.size() - 1)[1], interval[1]);
        }
       }

       return answer.toArray(new int[answer.size()][]);
    }
}