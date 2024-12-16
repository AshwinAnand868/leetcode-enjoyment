class Pair {
    double delta;
    int index;

    Pair(double delta, int index) {
        this.delta = delta;
        this.index = index;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        int n = classes.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.delta, a.delta);
        });

        // populate the pq
        for (int i = 0; i < n; i++) {
            double currentPr = classes[i][0] / (classes[i][1] * 1.0);
            double newPr = (classes[i][0] + 1) / ((classes[i][1] + 1) * 1.0);

            double delta = newPr - currentPr;
            pq.offer(new Pair(delta, i));
        }

        while (extraStudents > 0) {

            Pair topPair = pq.peek();
            pq.poll();

            double delta = topPair.delta;
            int idx = topPair.index;

            // increment both the pass and total counts for the index
            classes[idx][0]++;
            classes[idx][1]++;

            // as the pair was polled, and the count has been incremented, there is a
            // need to add another pair to reflect these counts

            double currentPr = classes[idx][0] / (classes[idx][1] * 1.0);
            double newPr = (classes[idx][0] + 1) / ((classes[idx][1] + 1) * 1.0);

            delta = newPr - currentPr;
            pq.offer(new Pair(delta, idx));

            extraStudents--;
        }

        double maxAverageRatio = 0.0;
        for (int i = 0; i < n; ++i) {
            double currentPr = classes[i][0] / (classes[i][1] * 1.0);
            maxAverageRatio += currentPr;
        }

        return maxAverageRatio / n;

//         int n = classes.length;
//         double[] pR = new double[n]; // stores the pass ratio of each class
//         double maxAverageRatio = 0.0;

//         for (int i = 0; i < n; i++) {
//             pR[i] = classes[i][0] / (classes[i][1] * 1.0);
//         }

//         while (extraStudents > 0) {

//             double[] updatedPr = new double[n];

//             for (int i = 0; i < n; i++) {
//                 double newRatio = (classes[i][0] + 1) / ((classes[i][1] + 1) * 1.0); // increment each class both counts
//                                                                                      // by 1
//                 updatedPr[i] = newRatio;
//             }

//             double bestDelta = 0.0;
//             int bestClassIdx = 0;

//             for (int i = 0; i < n; i++) {
//                 double delta = updatedPr[i] - pR[i];
//                 if (delta > bestDelta) {
//                     bestClassIdx = i;
//                     bestDelta = delta;
//                 }
//             }

//             pR[bestClassIdx] = updatedPr[bestClassIdx]; // set the max updated pass ratio to the original array

//             // update both the best class total and pass students to reflect for the next
//             // iteration
//             classes[bestClassIdx][0]++;
//             classes[bestClassIdx][1]++;
//             extraStudents--;
//         }

//         for (double pr : pR) {
//             maxAverageRatio += pr;
//         }

//         return maxAverageRatio / n; 
    }
}