class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        // Using priority queue to store maximum value of values[i] + i till i-th index

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.offer(values[0] + 0); // 0 for completeness

        int maxScore = values[0];
        
        for(int j = 1; j < values.length; ++j) {
            maxScore = Math.max(maxScore, pq.peek() + values[j] - j);
            pq.offer(values[j] + j); // add current to the top
        }

        return maxScore;



        // Using an array to store maximum value of values[i] + i till i-th index

        // int[] valuesIPlusI = new int[values.length];
        // valuesIPlusI[0] = values[0] + 0; // initially the i is 0

        // for(int i = 1; i < values.length; ++i) {
        //     valuesIPlusI[i] = Math.max(values[i] + i, valuesIPlusI[i - 1]);
        // }

        // int maxScore = valuesIPlusI[0];
        // for(int j = 1; j < values.length; ++j) {
        //     maxScore = Math.max(valuesIPlusI[j - 1] + values[j] - j, maxScore);
        // }

        // return maxScore;
    }
}