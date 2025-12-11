class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prevPoint = points[0];
        int count = 1; // considering one balloon to burst initially

        for(int i = 1; i < points.length; ++i) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][1];

            int prevStartPoint = prevPoint[0];
            int prevEndPoint = prevPoint[1];

            if(prevEndPoint < currStartPoint) { // no overlap
                // need to use one arrow
                count++;
                prevPoint = points[i]; // update previous point to current point
            } else { // overlap
                // find the common region of overlapped area
                prevPoint[0] = Math.max(prevStartPoint, currStartPoint);
                prevPoint[1] = Math.min(prevEndPoint, currEndPoint);
            }
        }

        return count;
    }
}