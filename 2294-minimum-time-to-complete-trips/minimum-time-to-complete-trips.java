class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        while (left < right) {
            long mid = left + (right - left) / 2;

            long trips = 0;
            for (int t : time) {
                trips += mid / t;

                if (trips >= totalTrips) break;
            }

            if (trips >= totalTrips) {
                right = mid; // can we do it in even shorter time
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}