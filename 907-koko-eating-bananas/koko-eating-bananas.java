class Solution {

    public int findMaximum(int[] piles) {
        int max = 0;

        for(int i = 0; i < piles.length; ++i) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }

    public int calculateTotalHours(int[] piles, int hourlySpeed) {
        int totalHours = 0;

        for(int i = 0; i < piles.length; ++i) {
            totalHours += Math.ceil((double)piles[i] / hourlySpeed);
        }

        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 0;

        int maxBananas = findMaximum(piles);

        int low = 1;
        int high = maxBananas;
        int ans = 0;

        while(low <= high) {
            int mid = (low + high) / 2;
            
            int totalHours = calculateTotalHours(piles, mid);

            if(totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // for(int i = 1; i <= maxBananas; ++i) { 
        //     int totalHours = calculateTotalHours(piles, i);
        //     if(totalHours <= h) return i; // hourly speed
        // }

        return low; // dummy return statement
    }
}