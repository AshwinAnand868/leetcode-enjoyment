class Solution {

    private boolean checkMidGood(int[] piles, int h, int potentialSpeed) {
        int currHours = 0;

        for(int i = 0; i < piles.length; ++i) {
            if(piles[i] <= potentialSpeed) {
                currHours++;
            } else {
                currHours += Math.ceil((double) piles[i] / potentialSpeed);
            }

            if(currHours > h) {
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; ++i) {
            max = Math.max(piles[i], max);
        }
        
        int minSpeed = Integer.MAX_VALUE;
        int low = 1;
        int high = max;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(checkMidGood(piles, h, mid)) {
                minSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minSpeed;
    }
}