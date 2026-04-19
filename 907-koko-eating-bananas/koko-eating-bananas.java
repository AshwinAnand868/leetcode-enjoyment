class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); // max speed

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;

            for(int pile : piles) {
                hours += Math.ceil((double)pile / mid);
            }

            if(hours <= h) {
                right = mid - 1; // reduce the speed to try more
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}