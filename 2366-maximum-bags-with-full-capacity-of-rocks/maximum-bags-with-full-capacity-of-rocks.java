class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] diff = new int[n];
        int fullBags = 0;

        for(int i = 0; i < n; ++i) {
            diff[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(diff);

        for(int i = 0; additionalRocks > 0 && i < n; ++i) {
            if(additionalRocks >= diff[i]) {
                fullBags++;
                additionalRocks -= diff[i];
            }
        }

        return fullBags;
    }
}