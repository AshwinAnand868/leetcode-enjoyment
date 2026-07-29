class Solution {

    private boolean checkMidIsGood(int[] piles, int hours, int potentialSpeed) {

        int currHours = 0;

        for(int i = 0; i < piles.length && currHours <= hours; ++i){
            if(piles[i] <= potentialSpeed) {
                currHours++;
            } else {
                int pile = piles[i];
                currHours += Math.ceil((double) piles[i]/potentialSpeed);
            }
        }

        return currHours > hours ? false : true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; ++i) {
            maxSpeed = Math.max(piles[i], maxSpeed);
        }

        int low = 1;
        int high = maxSpeed;
        int minSpeed = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(checkMidIsGood(piles, h, mid)) {
                minSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minSpeed;
    }
}