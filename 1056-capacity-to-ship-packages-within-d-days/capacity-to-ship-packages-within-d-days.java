class Solution {

    public int findDaysForACapacity(int[] weights, int capacity) {
        int load = 0; // initial load
        int days = 1;

        for(int i = 0; i < weights.length; ++i) {
            if(weights[i] + load > capacity) {
                // capacity reached! let's ship the current load before adding more
                days += 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        if(days > weights.length) return -1;

        //Find the maximum and the summation:
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while(low <= high) {
            int mid = (low + high) / 2;

            int nDays = findDaysForACapacity(weights, mid);

            if(nDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}