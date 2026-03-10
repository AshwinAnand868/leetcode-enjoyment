class Solution {

    public boolean inAtLeast(int[] time, long timeTaken, int totalTrips) {

        long trips = 0;

        for(int t : time) {
            trips += timeTaken / t;
        }

        return trips >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {

        long lb = 1;

        int min = Integer.MAX_VALUE;

        for(int t : time) {
            min = Math.min(min, t);
        }

        long ub = (long) min * totalTrips;

        while(lb < ub) {

            long mid = lb + (ub - lb) / 2;

            if(inAtLeast(time, mid, totalTrips)) {
                ub = mid;
            } else {
                lb = mid + 1;
            }
        }

        return lb;
    }
}
