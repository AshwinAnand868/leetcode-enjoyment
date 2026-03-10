class Solution {

    public int[] findMaximumAndMinimum(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int n = bloomDay.length;

        for(int i = 0; i < n; ++i) {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        return new int[] {min, max};
    }

    public boolean checkTotalBouquets(int[] bloomDay, int currentDay, int k, int m) {
        int nFlowers = 0;
        int nBouquets = 0;
        for(int i = 0; i < bloomDay.length; ++i) {
            if(currentDay >= bloomDay[i]) {
                nFlowers++;
                if(nFlowers % k == 0) {
                    nBouquets++;
                }
            } else {
                nFlowers = 0;
            }
        }

        return nBouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long) m * k;

        if(val > (long) n) { // if no of flowers needed is greator than total flowers, return -1
            return -1;
        }

        int[] minMax = findMaximumAndMinimum(bloomDay);
        int low = minMax[0];
        int high = minMax[1];

        while(low <= high) {
            int mid = (high + low) / 2;

            if(checkTotalBouquets(bloomDay, mid, k, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}