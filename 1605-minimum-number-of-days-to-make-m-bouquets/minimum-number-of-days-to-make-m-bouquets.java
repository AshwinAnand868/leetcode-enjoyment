class Solution {
    private int[] findMaxAndMinDay(int[] bloomDay) {
        int maxBloomDay = Integer.MIN_VALUE;
        int minBloomDay = Integer.MAX_VALUE;

        for(int i = 0; i < bloomDay.length; ++i) {
            maxBloomDay = Math.max(maxBloomDay, bloomDay[i]);
            minBloomDay = Math.min(minBloomDay, bloomDay[i]);
        }

        return new int[] {minBloomDay, maxBloomDay};
    }

    private boolean possibleWithInMidDays(int[] bloomDay, int m, int k, int daysPassed) {
        int currentBouqets = 0;

        int flowersPicked = 0;

        for(int i = 0; i < bloomDay.length && currentBouqets < m; ++i) {
            if(daysPassed >= bloomDay[i]) {
                flowersPicked++;

                if(flowersPicked == k) {
                    currentBouqets++;
                    flowersPicked = 0; // for next bouqet
                }
            } else  {
                flowersPicked = 0;
            }
        }

        return currentBouqets == m ? true : false;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if((long) m * k > bloomDay.length) return -1;

        int[] maxMin = findMaxAndMinDay(bloomDay);

        int low = maxMin[0];
        int high = maxMin[1];

        int ans = Integer.MIN_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(possibleWithInMidDays(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}